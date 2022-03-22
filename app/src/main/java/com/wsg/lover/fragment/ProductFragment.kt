package com.wsg.lover.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.wsg.lover.R
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.viewModel.GiftViewModel

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */
class ProductFragment : BaseFragment() {

    private var viewModel: GiftViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gift, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initVm()
        initObserve()
        initData()
    }

    private fun initView(view: View) {

    }

    private fun initVm() {
        viewModel = ViewModelProvider(this).get(GiftViewModel::class.java)
    }

    private fun initObserve() {
        viewModel?.gifts?.observe(viewLifecycleOwner) {

        }
    }

    private fun initData() {
        viewModel?.getGifts()
    }
}