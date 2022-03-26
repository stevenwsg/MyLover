package com.wsg.lover.util;

import android.content.Context;

import java.util.Random;

/**
 * Create on 2022/3/26.
 *
 * @author wangshengguo.
 */
public class RandomUtil {

    private static Random random = new Random();

    public static int getDrawableResUtil(Context context) {
        String imgName = "love" + random.nextInt(20);
        return context.getResources().getIdentifier(imgName, "drawable", context.getPackageName());
    }

    public static int getRandomIndex(int size) {
        return random.nextInt(size);
    }
}
