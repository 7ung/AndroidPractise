package com.tunghh.footballdata.commonswidget;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.tunghh.footballdata.R;

/**
 * Created by TungHH on 8/24/2016.
 */
public class AnimationHelper {

    public static void expand(final View v, int height) {
        final int targetHeight = height;

        v.setVisibility(View.VISIBLE);
        v.getLayoutParams().height = 1;
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(300);
        v.startAnimation(a);
    }

    public static void collapse(final View v, int height) {
        final int initialHeight = height;
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(300);
        v.startAnimation(a);
    }

    public static void sildeDown(Context context, final View v){
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        anim.reset();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.clearAnimation();
        v.startAnimation(anim);
    }

    public static void sildeUp(Context context, final View v){
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        anim.reset();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.clearAnimation();
        v.startAnimation(anim);
    }

}
