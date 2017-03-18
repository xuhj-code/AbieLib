package com.tsign.xhj.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

/**
 * Created by haru on 2017/3/18.
 */

public class HaruUtil {
    /**
     * 开启View闪烁效果
     */

    public static void startFlick(View view) {
        if (null == view) {
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(500);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(alphaAnimation);
    }

    /**
     * 取消View闪烁效果
     */

    public static void stopFlick(View view) {
        if (null == view) {
            return;
        }
        view.clearAnimation();
    }

    /**
     * 平台型号
     *
     * @return
     */
    public static String getPlatformModel() {
        return android.os.Build.MODEL;
    }
}
