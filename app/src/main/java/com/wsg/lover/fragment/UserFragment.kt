package com.wsg.lover.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wsg.lover.base.BaseFragment
import com.wsg.lover.databinding.FragmentCoinBinding

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */
class UserFragment : BaseFragment() {

    private var _binding: FragmentCoinBinding? = null

    private val binding get() = _binding!!

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}