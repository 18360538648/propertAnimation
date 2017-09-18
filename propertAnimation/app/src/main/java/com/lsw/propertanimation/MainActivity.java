package com.lsw.propertanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button btn_click;
    private LinearLayout ll_fisrt;
    private ImageView iv_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click = (Button) findViewById(R.id.btn_click);
        ll_fisrt = (LinearLayout) findViewById(R.id.ll_fisrt);
        iv_second = (ImageView) findViewById(R.id.iv_second);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstAnimation();
            }
        });
        iv_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondAnimation();
            }
        });
    }

    /**
     * 第一个动画效果
     */
    public void firstAnimation() {
        // 饶x轴旋转
        ObjectAnimator firstRotationXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "rotationX", 0f, 20f);
        firstRotationXAnimation.setDuration(300);
        // 改变透明度
        ObjectAnimator firstAlapAnimation = ObjectAnimator.ofFloat(ll_fisrt, "alpha", 1f, 0.5f);
        firstAlapAnimation.setDuration(300);
        // X轴缩放
        ObjectAnimator firstScaleXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "scaleX", 1f, 0.8f);
        firstScaleXAnimation.setDuration(300);
        // Y轴缩放
        ObjectAnimator firstScaleYAnimation = ObjectAnimator.ofFloat(ll_fisrt, "scaleY", 1f, 0.8f);
        firstScaleYAnimation.setDuration(300);
        // 200ms以后恢复旋转
        ObjectAnimator firstResumeRotationXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "rotationX", 20f, 0f);
        firstResumeRotationXAnimation.setDuration(200);
        firstResumeRotationXAnimation.setStartDelay(200);
        // 200ms以后将整个布局上移
        ObjectAnimator firstTranslationYAnimation = ObjectAnimator.ofFloat(ll_fisrt, "translationY", 0, -ll_fisrt.getHeight() * 0.1f);
        firstTranslationYAnimation.setDuration(200);
        firstTranslationYAnimation.setStartDelay(200);
        // 第二个动画，显示出来
        // translationY的参数为从什么位置到什么位置
        ObjectAnimator secondTranslationYAnimator = ObjectAnimator.ofFloat(iv_second, "translationY", iv_second.getHeight(), 0);
        secondTranslationYAnimator.setDuration(300);
        // 设置动画监听
        secondTranslationYAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                iv_second.setVisibility(View.VISIBLE);
            }
        });
        // 动画加入集合
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(firstRotationXAnimation, firstAlapAnimation, firstScaleXAnimation, firstScaleYAnimation, firstResumeRotationXAnimation, firstTranslationYAnimation, secondTranslationYAnimator);
        animatorSet.start();
    }

    /**
     * 第二个动画效果,按照第一个效果做逆反操作
     */
    public void secondAnimation() {
        // 饶x轴旋转
        ObjectAnimator firstRotationXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "rotationX", 0f, 20f);
        firstRotationXAnimation.setDuration(300);
        // 改变透明度
        ObjectAnimator firstAlapAnimation = ObjectAnimator.ofFloat(ll_fisrt, "alpha", 0.5f, 1f);
        firstAlapAnimation.setDuration(300);
        // X轴缩放
        ObjectAnimator firstScaleXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "scaleX", 0.8f, 1f);
        firstScaleXAnimation.setDuration(300);
        // Y轴缩放
        ObjectAnimator firstScaleYAnimation = ObjectAnimator.ofFloat(ll_fisrt, "scaleY", 0.8f, 1f);
        firstScaleYAnimation.setDuration(300);
        // 200ms以后恢复旋转
        ObjectAnimator firstResumeRotationXAnimation = ObjectAnimator.ofFloat(ll_fisrt, "rotationX", 20f, 0f);
        firstResumeRotationXAnimation.setDuration(200);
        firstResumeRotationXAnimation.setStartDelay(200);
        // 200ms以后将整个布局上移
        ObjectAnimator firstTranslationYAnimation = ObjectAnimator.ofFloat(ll_fisrt, "translationY", -ll_fisrt.getHeight() * 0.1f, 0);
        firstTranslationYAnimation.setDuration(200);
        firstTranslationYAnimation.setStartDelay(200);

        ObjectAnimator secondTranslationYAnimator = ObjectAnimator.ofFloat(iv_second, "translationY", 0, iv_second.getHeight());
        secondTranslationYAnimator.setDuration(300);
        // 设置动画监听
        secondTranslationYAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                iv_second.setVisibility(View.GONE);
            }
        });
        // 动画加入集合
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(firstRotationXAnimation, firstAlapAnimation, firstScaleXAnimation, firstScaleYAnimation, firstResumeRotationXAnimation, firstTranslationYAnimation, secondTranslationYAnimator);
        animatorSet.start();
    }

}
