package com.wsg.lover.adapter

import com.wsg.lover.bean.LoveGift
import me.drakeet.multitype.MultiTypeAdapter

/**
 * Create on 2022/3/26.
 *
 * @author wangshengguo.
 */
class ProductAdapter : MultiTypeAdapter() {

    init {
        register(LoveGift::class.java, ProductViewBinder())
    }
}