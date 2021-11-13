package com.wsg.lover.activity

import android.content.Intent
import android.os.Bundle
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import pl.droidsonroids.gif.GifImageView

/**
 * Create on 2021/10/23.
 *
 * @author wangshengguo.
 */
class YellowRabbitActivity : BaseActivity() {

    private var gifView: GifImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yellow_rabbit)

        gifView = findViewById(R.id.gifView)
        gifView?.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
        }
    }
}