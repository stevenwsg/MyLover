package com.wsg.lover

import android.app.Activity
import android.app.Application
import android.os.Bundle
import cn.bmob.v3.Bmob
import com.wsg.lover.util.ActivityManager
import com.wsg.lover.util.Constants

/**
 * Create on 2022/3/18.
 *
 * @author wangshengguo.
 */
class LoveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Bmob.initialize(this, Constants.BMOB_APP_ID)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                ActivityManager.instance.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                ActivityManager.instance.removeActivity(activity)
            }

        })
    }
}