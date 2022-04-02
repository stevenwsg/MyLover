package com.wsg.lover.adapter

import com.wsg.lover.bean.Coin
import me.drakeet.multitype.MultiTypeAdapter

/**
 * Create on 2022/3/31.
 *
 * @author wangshengguo.
 */
class CoinAdapter : MultiTypeAdapter() {
    init {
        register(Coin::class.java, CoinViewBinder())
    }
}