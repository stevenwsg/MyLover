package com.wsg.lover

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.wsg.lover.activity.GifActivity
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.util.Constants

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.rabbit).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.RABBIT)
            startActivity(intent)
        }


        findViewById<TextView>(R.id.lovely_rabbit).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.LOVELY_RABBIT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.two_rabbit).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.TWO_RABBIT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.static_rabbit).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.STATIC_RABBIT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.noFace).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.NO_FACE)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.lovely_cat).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.LOVELY_CAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.shy_cat).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.SHY_CAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.scary_cat).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.SCARY_CAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.moonlight_cat).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.MOON_LIGHT_CAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.dog).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.DOG_EAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.a_cat).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.A_CAT)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.cat_face).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.CAT_FACE)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.sheep).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.SHEEP)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.ghost).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.GHOST)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.girl).setOnClickListener {
            val intent = Intent(this, GifActivity::class.java)
            intent.putExtra(GifActivity.TYPE, Constants.CUTE_GIRL)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.button).setOnClickListener {
            Toast.makeText(this, "喜欢喜欢, 本小可爱好喜欢 ~", Toast.LENGTH_SHORT).show()
        }

    }
}