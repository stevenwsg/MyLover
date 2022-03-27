package com.wsg.lover.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.wsg.lover.R
import com.wsg.lover.bean.LoveGift
import com.wsg.lover.databinding.ItemProductBinding
import me.drakeet.multitype.ItemViewBinder

/**
 * Create on 2022/3/26.
 *
 * @author wangshengguo.
 */
class ProductViewBinder : ItemViewBinder<LoveGift, ProductViewBinder.ProductHolder>() {

    class ProductHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        var photo: ImageView? = null
        var name: TextView? = null
        var coin: TextView? = null

        init {
            photo = rootView.findViewById(R.id.photo)
            name = rootView.findViewById(R.id.name)
            coin = rootView.findViewById(R.id.coin)
        }
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ProductHolder {
        return ProductHolder(ItemProductBinding.inflate(inflater).root)
    }

    override fun onBindViewHolder(holder: ProductHolder, item: LoveGift) {
        holder.name?.text = item.name
        if (!TextUtils.isEmpty(item.photo)) {
            holder.photo?.let { Glide
                .with(holder.itemView.context)
                .load(item.photo)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                .into(it) }
        }
        holder.coin?.text = item.coin.toString()
    }
}