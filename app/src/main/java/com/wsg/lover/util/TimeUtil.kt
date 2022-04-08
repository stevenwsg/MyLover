package com.wsg.lover.util

import java.text.SimpleDateFormat
import java.util.*

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

    fun calDays(): Int {
        return TimeInternal.daysBetween(getCurrentTime().signTime, "2021-11-02");
    }

    /**
     * 获取当前时间
     */
    fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val calendar = Calendar.getInstance()
        return sdf.format(calendar.time)
    }
}