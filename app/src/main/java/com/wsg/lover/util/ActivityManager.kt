package com.wsg.lover.util

import android.app.Activity

/**
 * Create on 2022/4/6.
 *
 * @author wangshengguo.
 */
class ActivityManager private constructor() {

    companion object {
        val instance by lazy {
            ActivityManager()
        }
    }

    private val activitySet = hashSetOf<Activity>()

    fun addActivity(activity: Activity) {
        activitySet.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activitySet.remove(activity)
    }


    fun getTopActivity(): Activity {
        return activitySet.first()
    }

}