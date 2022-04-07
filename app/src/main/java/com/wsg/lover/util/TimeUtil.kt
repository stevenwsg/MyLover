package com.wsg.lover.util

/**
 * Create on 2022/4/6.
 *
 * @author wangshengguo.
 */
class TimeUtil private constructor() {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            TimeUtil()
        }
    }

    fun isSameDay(): Boolean {
        return false
    }

    fun calDays(): Int {
        return 1
    }
}