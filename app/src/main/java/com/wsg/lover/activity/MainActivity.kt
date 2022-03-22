package com.wsg.lover.activity

import android.os.Bundle
import com.wsg.lover.R
import com.wsg.lover.base.BaseActivity
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.databinding.ActivityMainBinding
import com.wsg.lover.fragment.ProductFragment
import com.wsg.lover.fragment.UserFragment

/**
 * Create on 2021/11/20.
 *
 * @author wangshengguo.
 */
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var giftFragment: ProductFragment
    private lateinit var userFragment: UserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        giftFragment = ProductFragment()
        userFragment = UserFragment()
        supportFragmentManager.beginTransaction().replace(R.id.content, giftFragment).commitAllowingStateLoss()

        binding.giftLayoutView.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.content, giftFragment).commitAllowingStateLoss()
        }

        binding.mineLayoutView.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.content, userFragment).commitAllowingStateLoss()
        }
    }
}