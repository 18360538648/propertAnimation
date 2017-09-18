package com.lsw.propertanimation;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Luosiwei on 2017/9/18.
 */

public class ClickActivity extends Activity {
    private Button btn_1;
    private Button btn_2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);

    }

    public void btn1(View view) {
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(btn_1, btn_1.getWidth() / 2, btn_1.getHeight() / 2, 0, btn_1.getHeight());
        circularReveal.setDuration(1000);
        circularReveal.setInterpolator(new AccelerateInterpolator());
        circularReveal.start();
    }

    public void btn2(View view) {
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(btn_2, 0, 0, 0, (float) Math.hypot(btn_2.getWidth(), btn_2.getHeight()));
        circularReveal.setDuration(1000);
        circularReveal.setInterpolator(new AccelerateInterpolator());
        circularReveal.start();
    }
}
