package com.wsg.lover.bean

import cn.bmob.v3.BmobObject

/**
 * Create on 2022/3/19.
 *
 * @author wangshengguo.
 */
data class LoveContent(val content: String, val photo: String) : BmobObject()