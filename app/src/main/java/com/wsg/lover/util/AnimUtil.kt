package com.wsg.lover.util

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator

/**
 * Create on 2022/4/8.
 *
 * @author wangshengguo.
 *
 * 顶层函数
 */
fun startScaleAnim(view: View) {

    view.apply {
        visibility = View.VISIBLE
        val animSet = AnimatorSet()
        val scaleX = ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(this, "scaleY", 0f, 1f)

        animSet.duration = 1000
        animSet.interpolator = AccelerateInterpolator()
        animSet.play(scaleX).with(scaleY)
        animSet.start()

        postDelayed({
            visibility = View.GONE
        }, 3000)
    }
}