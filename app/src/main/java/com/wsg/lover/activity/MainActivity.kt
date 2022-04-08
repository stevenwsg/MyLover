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

        supportFragmentManager
            .beginTransaction()
            .add(R.id.content, giftFragment)
            .add(R.id.content, userFragment)
            .show(giftFragment)
            .hide(userFragment)
            .commitAllowingStateLoss()

        binding.giftLayoutView.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .show(giftFragment)
                .hide(userFragment)
                .commitAllowingStateLoss()
            binding.giftImageView.setImageResource(R.mipmap.icon_shop_selected)
            binding.mineImageView.setImageResource(R.mipmap.icon_mine)
        }

        binding.mineLayoutView.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .show(userFragment)
                .hide(giftFragment)
                .commitAllowingStateLoss()

            binding.giftImageView.setImageResource(R.mipmap.icon_shop)
            binding.mineImageView.setImageResource(R.mipmap.icon_mine_selected)

            userFragment.refresh()
        }
    }
}