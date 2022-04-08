package com.wsg.lover.activity

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gyf.immersionbar.ImmersionBar
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.util.TimeInternal
import com.wsg.lover.util.TimeUtil
import com.wsg.lover.viewModel.LoveViewModel

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */

private const val TAG = "SplashActivity"

class SplashActivity : BaseActivity() {

    private var viewModel: LoveViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<TextView>(R.id.time).setText("今天是我们在一起的${TimeUtil.instance.calDays()}天 \n 又是超级爱你的一天哦\uD83D\uDE18")

        viewModel = ViewModelProvider(this).get(LoveViewModel::class.java)
        viewModel?.getLoves()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoveActivity::class.java))
            finish()
        }, 2000)
    }
}