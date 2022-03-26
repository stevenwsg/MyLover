package com.wsg.lover.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.databinding.ActivityLoveBinding
import com.wsg.lover.util.ConstantsLove
import com.wsg.lover.util.RandomUtil

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */
class LoveActivity : BaseActivity() {

    private lateinit var binding: ActivityLoveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, YellowRabbitActivity::class.java))
            finish()
        }, 5000)
    }

    private fun initView() {
        binding.gifView.setImageResource(RandomUtil.getDrawableResUtil(this))
        ConstantsLove.getLove()?.apply {
            binding.name.text = this.content
        }
    }

}