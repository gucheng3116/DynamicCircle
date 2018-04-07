package com.gucheng.dynamiccircle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private int mCurrentProgress = 0;
    CustomCircle mCustomCircle;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mCurrentProgress += 5;
            mCustomCircle.setProgress(mCurrentProgress);
            handler.postDelayed(this, 30);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomCircle = (CustomCircle)findViewById(R.id.custom_circle);
        handler.postDelayed(runnable, 500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
