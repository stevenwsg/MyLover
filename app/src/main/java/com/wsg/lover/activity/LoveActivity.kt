package com.wsg.lover.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.ImmersionBar
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.util.ConstantsLove
import com.wsg.lover.viewModel.GiftViewModel

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */
class LoveActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love)
        initView()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, YellowRabbitActivity::class.java))
            finish()
        }, 5000)
    }

    private fun initView() {
        ConstantsLove.getLove()?.apply {
            findViewById<TextView>(R.id.name).text = this.content
        }
    }

}