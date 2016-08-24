package com.tunghh.footballdata.commons.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

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

}
