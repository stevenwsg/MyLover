package com.wsg.lover.bean

import cn.bmob.v3.BmobObject

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */
data class LoveGift(
    val name: String,
    val photo: String,
    val coin: Int
) : BmobObject()