package com.wsg.lover.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsg.lover.R
import com.wsg.lover.adapter.ProductAdapter
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.databinding.FragmentGiftBinding
import com.wsg.lover.viewModel.GiftViewModel

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

        initView()
        initVm()
        initObserve()
        initData()
    }

    private fun initView() {
        binding.product.layoutManager = GridLayoutManager(context, 2)
        adapter = ProductAdapter()
        binding.product.adapter = adapter
    }

    private fun initVm() {
        viewModel = ViewModelProvider(this).get(GiftViewModel::class.java)
    }

    private fun initObserve() {
        viewModel?.gifts?.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
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