package com.wsg.lover.bean

/**
 * Create on 2022/4/4.
 *
 * @author wangshengguo.
 */
public const val RESULT_OK = 0
public const val RESULT_FAIL = 1

data class ConvertGiftResult(val result: Int, val newCoin: Int)