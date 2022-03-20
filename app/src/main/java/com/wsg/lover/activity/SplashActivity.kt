package com.wsg.lover.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gyf.immersionbar.ImmersionBar
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.viewModel.LoveViewModel

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */
class SplashActivity : BaseActivity() {

    private var viewModel: LoveViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(this).get(LoveViewModel::class.java)
        viewModel?.getLoves()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoveActivity::class.java))
            finish()
        }, 2000)
    }
}