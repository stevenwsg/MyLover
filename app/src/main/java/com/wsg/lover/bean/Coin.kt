package com.wsg.lover.bean

import cn.bmob.v3.BmobObject

/**
 * Create on 2022/3/31.
 *
 * @author wangshengguo.
 */
data class Coin(
    val name: String,
    val num: Int
) : BmobObject()