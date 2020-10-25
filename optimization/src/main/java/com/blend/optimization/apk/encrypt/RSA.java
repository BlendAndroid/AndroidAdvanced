package com.blend.optimization.apk.encrypt;


import android.util.Base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;


public class RSA {
    public static String ALGORITHM = "RSA";

    //指定key的位数
    public static int KEYSIZE = 1024;//65536

    //指定公钥存放的文件
    public static String PUBLIC_KEY_FILE = "public_key.dat";

    //指定私钥存放的文件
    public static String PRIVATE_KEY_FILE = "private_key.dat";


    public static void generateKeyPair() throws Exception {
        SecureRandom sr = new SecureRandom();
        //需要一个KeyPairGenerator来生成钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEYSIZE, sr);
        //生成
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));

        objectOutputStream1.writeObject(publicKey);
        objectOutputStream2.writeObject(privateKey);
        objectOutputStream2.close();
        objectOutputStream1.close();

    }

    /**
     * 加密
     */
    public static String encrypt(String source) throws Exception {
        generateKeyPair();
        //取出公钥
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        //开始使用
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes();
        byte[] b1 = cipher.doFinal(b);
        //转一下base64
        return new String(Base64.encode(b1, Base64.NO_WRAP));

    }

    /**
     * 解密
     */
    public static String decrypt(String source) throws Exception {

        //取出公钥
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        //开始使用
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] b = Base64.decode(source, Base64.DEFAULT);
        byte[] b1 = cipher.doFinal(b);

        return new String(b1);

    }

    public static void test() throws Exception {
        String content = "BlendAndroid";
        String password = encrypt(content);
        System.out.println("RSA 密文" + password);

        //到了服务器以后
        String target = decrypt(password);
        System.out.println("RSA 明文" + target);
    }
}









