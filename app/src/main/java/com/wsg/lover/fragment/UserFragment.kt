package com.wsg.lover.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsg.lover.adapter.CoinAdapter
import com.wsg.lover.adapter.CoinClickListener
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.bean.Coin
import com.wsg.lover.databinding.FragmentCoinBinding
import com.wsg.lover.util.SpHelper
import com.wsg.lover.viewModel.CoinViewModel

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */

private const val TAG = "UserFragment"

class UserFragment : BaseFragment() {

    private var _binding: FragmentCoinBinding? = null

    private val binding get() = _binding!!

    private var viewModel: CoinViewModel? = null
    private var adapter: CoinAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = CoinAdapter(object : CoinClickListener {
            override fun onClick(item: Coin) {
                viewModel?.earnCoin(item)
            }
        })
        binding.rv.adapter = adapter

        initViewModel()
        initObserve()
        initData()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
    }

    private fun initObserve() {
        viewModel?.apply {
            coins.observe(viewLifecycleOwner) {
                Log.d(TAG, "coins size ${it.size}")
                adapter?.apply {
                    items = it
                    notifyDataSetChanged()
                }
            }
            myCoin.observe(viewLifecycleOwner) {
                binding.myCoin.text = "我的积分 $it"
                context?.apply {
                    SpHelper.saveCoin(this, it)
                }
            }
        }
    }

    private fun initData() {
        viewModel?.apply {
            getCoins()
            getMyCoin()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}