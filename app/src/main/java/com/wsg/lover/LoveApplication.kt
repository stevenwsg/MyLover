package com.wsg.lover

import android.app.Application
import cn.bmob.v3.Bmob
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
    }
}