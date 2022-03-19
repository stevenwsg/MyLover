package com.wsg.lover.activity

import android.os.Bundle
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
        ImmersionBar.with(this).init()
    }
}