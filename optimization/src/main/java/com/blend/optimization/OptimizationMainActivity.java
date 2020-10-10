package com.blend.optimization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blend.optimization.bitmapmanage.BitmapManageMainActivity;
import com.blend.optimization.memory.MemoryMainActivity;
import com.blend.optimization.startup.AppStartupMainActivity;
import com.blend.optimization.uidrawing.UiDrawingMainActivity;

public class OptimizationMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimization_main);

        findViewById(R.id.appStartup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptimizationMainActivity.this, AppStartupMainActivity.class));
            }
        });

        findViewById(R.id.uiDrawing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptimizationMainActivity.this, UiDrawingMainActivity.class));
            }
        });

        findViewById(R.id.memory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptimizationMainActivity.this, MemoryMainActivity.class));
            }
        });

        findViewById(R.id.bitmapManage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptimizationMainActivity.this, BitmapManageMainActivity.class));
            }
        });
    }
}