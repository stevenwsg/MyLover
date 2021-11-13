package com.wsg.lover.activity

import android.os.Bundle
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.util.Constants
import pl.droidsonroids.gif.GifImageView

/**
 * Create on 2021/10/23.
 *
 * @author wangshengguo.
 */
class GifActivity : BaseActivity() {

    companion object {
        const val TYPE = "type"
    }

    private var gifView: GifImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif)
        gifView = findViewById(R.id.gitView)

        initData()
    }

    private fun initData() {

        when (intent?.getStringExtra(TYPE)) {
            Constants.RABBIT -> {
                gifView?.setImageResource(R.drawable.yello_rabbit)
            }
            Constants.LOVELY_RABBIT -> {
                gifView?.setImageResource(R.drawable.love_rabbit2)
            }
            Constants.STATIC_RABBIT -> {
                gifView?.setImageResource(R.drawable.static_rabbit)
            }
            Constants.TWO_RABBIT -> {
                gifView?.setImageResource(R.drawable.two_bunnies)
            }
            Constants.NO_FACE -> {
                gifView?.setImageResource(R.drawable.no_face_bay)
            }
            Constants.DOG_EAT -> {
                gifView?.setImageResource(R.drawable.dog)
            }
            Constants.SCARY_CAT -> {
                gifView?.setImageResource(R.drawable.scary_cat)
            }
            Constants.LOVELY_CAT -> {
                gifView?.setImageResource(R.drawable.lovely_cats)
            }
            Constants.SHY_CAT -> {
                gifView?.setImageResource(R.drawable.shy_cat)
            }
            Constants.MOON_LIGHT_CAT -> {
                gifView?.setImageResource(R.drawable.moonlight_cat)
            }

            Constants.A_CAT -> {
                gifView?.setImageResource(R.drawable.a_cat)
            }
            Constants.CAT_FACE -> {
                gifView?.setImageResource(R.drawable.cat_face)
            }
            Constants.SHEEP -> {
                gifView?.setImageResource(R.drawable.sheep)
            }
            Constants.GHOST -> {
                gifView?.setImageResource(R.drawable.ghost)
            }
            Constants.CUTE_GIRL -> {
                gifView?.setImageResource(R.drawable.cute_girl)
            }

            else -> {

            }
        }
    }
}