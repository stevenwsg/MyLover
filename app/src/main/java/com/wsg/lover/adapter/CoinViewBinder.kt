package com.wsg.lover.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsg.lover.R
import com.wsg.lover.bean.Coin
import com.wsg.lover.databinding.FragmentGiftBinding
import com.wsg.lover.databinding.ItemCoinBinding
import me.drakeet.multitype.ItemViewBinder

/**
 * Create on 2022/3/31.
 *
 * @author wangshengguo.
 */
class CoinViewBinder : ItemViewBinder<Coin, CoinViewBinder.CoinViewHolder>() {

    class CoinViewHolder(binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        var name: TextView? = null
        var num: TextView? = null

        init {
            name = binding.name
            num = binding.coinNum
        }
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CoinViewHolder {
        return CoinViewHolder(ItemCoinBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, item: Coin) {
        holder.name?.text = item.name
        holder.num?.text = "${item.num} 积分"
    }
}