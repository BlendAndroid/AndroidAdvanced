package com.blend.algorithm.stack;

/**
 * 栈是限定仅在表尾进行插入和删除操作的线性表。
 * 允许插入和删除的一端称为栈顶（top），另一端称为栈底（bottom），不含任何数据元素的栈称为空栈。栈又称为后进先出的线性表。
 * 逆波兰表达式：
 * 标准四则运算表达式—中缀表达式 9+(3-1)X3+10/2
 * 计算机采用—后缀表达式 9 3 1 - 3 * + 10 2 / +
 * 中缀表达式转换为后缀表达式：数字输出，运算符进栈，括号匹配出栈，比栈顶优先级低就出栈（表中1>2）
 * <p>
 * 递归：程序调用自身的编程技巧称为递归（recursion）。 递归做为一种算法在程序设计语言中广泛应用。 一个过程或函数在其定义
 * 或说明中有直接或间接调用自身的一种方法， 它通常把一个大型复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解， 递
 * 归策略只需少量的程序就可描述出解题过程所需要的多次重复计算，大大地减少了程序的代码量。 递归的能力在于用有限的语句来定义
 * 对象的无限集合。
 * 一般来说，递归需要有边界条件、递归前进段和递归返回段。 当边界条件不满足时，递归前进；当边界条件满足时，递归返回。
 * 构成递归需具备的条件：
 * 1.子问题须与原始问题为同样的事，且更为简单；
 * 2.不能无限制地调用本身，须有个出口，化简为非递归状况处理。这个出口就是边界条件。
 * 当边界条件不满足时，递归前进；当边界条件满足时，递归返回。
 * 能用迭代写的，递归一定能写；但是能用递归写的，迭代不一定能写。
 * <p>
 * <p>
 * <p>
 * Hash表：哈希表（Hash table，也叫散列表） 是根据关键码值(Key value)而直接进行访问的数据结构，它通过把关键码值映射到表中
 * 一个位置来访问记录，以加快查找的速度。
 * 比较：
 * 数组(顺序表)：寻址容易。
 * 链表：插入与删除容易。
 * 哈希表：寻址容易，插入删除也容易的数据结构。
 * 散列函数与散列表大小hash冲突的解决方案：装填因子。
 * 为什么需要这个值？因为数据越接近数组最大值，可能产生冲突的情况就越多。
 * 缺点：扩容需要消费大量的空间和性能。
 * 应用：电话号码，字典，点歌系统，QQ，微信的好友等。
 * <p>
 * Hash源码中的设计：拉链发
 * 1.jdk1.8以前。数组 + 链表。
 * 2.jdk1.8之后。当链表的长度超过阈值时，链表就转换为红黑树。
 */
public class MyStack {

    /**
     * 汉诺塔问题
     * <p>
     * 汉诺塔问题实质上就是树的中序遍历。
     *
     * @param n 盘子的个数
     * @param A 开始的柱子
     * @param B 中间的柱子
     * @param C 结果的柱子
     */
    public static void hanoi(int n, String A, String B, String C) {
        if (n <= 1) {
            System.out.println(A + "----->" + C);
        } else {
            hanoi(n - 1, A, C, B);  //表示先将n-1个由A移到到B
            System.out.println(A + "----->" + C);   //输出移动的过程
            hanoi(n - 1, B, A, C);  //最后再将n-1由B移动到C
        }
    }


    /**
     * 有五只猴子摘了一些桃子，打算隔天早上起来分了吃。
     * 晚上的时候，第一只猴子偷偷起来把桃子分成五堆，还多了一个，就把多了的那个吃掉，并拿走了一堆。
     * 第二只猴子也偷偷起来将桃子分成了五堆，还是又多了一个，同样吃掉了这一颗桃子，并拿走了其中一堆。
     * 第三只、第四只、第五只猴子都做了同样的事情。请问这堆桃子最少有多少个？
     */
    public static int steal(int peach, int monkey) {
        if ((peach - 1) % 5 != 0) { //前面几个猴子，桃子数-1都应该能整除，如果遇到不能整除的，就返回猴子数
            return monkey;
        }
        peach = (peach - 1) / 5 * 4;
        return steal(peach, monkey + 1);
    }

    public static void monkeyStealPeach() {
        int peach = 1;
        while (steal(peach, 0) != 5) {
            peach++;
        }
        System.out.println("桃子：" + peach);
    }
}