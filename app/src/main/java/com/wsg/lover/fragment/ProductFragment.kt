package com.wsg.lover.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsg.lover.R
import com.wsg.lover.adapter.IConvertProduct
import com.wsg.lover.adapter.ProductAdapter
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.bean.LoveGift
import com.wsg.lover.bean.RESULT_FAIL
import com.wsg.lover.bean.RESULT_OK
import com.wsg.lover.databinding.FragmentGiftBinding
import com.wsg.lover.util.MyCoinUtil
import com.wsg.lover.util.SpHelper
import com.wsg.lover.viewModel.GiftViewModel
import es.dmoral.toasty.Toasty

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */
class ProductFragment : BaseFragment() {

    private var _binding: FragmentGiftBinding? = null
    private val binding get() = _binding!!

    private var viewModel: GiftViewModel? = null
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGiftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.refreshLayout.setOnRefreshListener { initData() }

        initView()
        initVm()
        initObserve()
        initData()
    }

    private fun initView() {
        binding.product.layoutManager = GridLayoutManager(context, 2)
        adapter = ProductAdapter(object : IConvertProduct {
            override fun convert(item: LoveGift) {
                if (context?.let { MyCoinUtil.instance.myCoin < item.coin } == true) {
                    Toasty.info(context!!, "积分不够哦，小可爱要继续加油哦", Toast.LENGTH_SHORT, true).show()
                } else {
                    viewModel?.convertGift(
                        MyCoinUtil.instance.myCoin - item.coin,
                        SpHelper.getMyCoinId(context!!)
                    )
                }
            }
        })
        binding.product.adapter = adapter
    }

    private fun initVm() {
        viewModel = ViewModelProvider(this).get(GiftViewModel::class.java)
    }

    private fun initObserve() {
        viewModel?.gifts?.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
            binding.refreshLayout.finishRefresh()
        }

        viewModel?.convertGiftResult?.observe(viewLifecycleOwner) {
            when (it.result) {
                RESULT_OK -> {
                    context?.let { it1 ->
                        Toasty.success(it1, "恭喜兑换成功，快告诉你的小宝贝兑换吧").show()
                        MyCoinUtil.instance.myCoin = it.newCoin
                    }

                }
                RESULT_FAIL -> {
                    context?.let { it1 -> Toasty.error(it1, "兑换失败， 小宝贝检查一下积分够嘛").show() }
                }
            }
        }
    }

    private fun initData() {
        viewModel?.getGifts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}