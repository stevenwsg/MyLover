package com.wsg.lover.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gyf.immersionbar.ImmersionBar
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoveActivity::class.java))
        }, 2000)
    }
}