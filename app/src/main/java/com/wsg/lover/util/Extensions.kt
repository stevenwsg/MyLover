package com.wsg.lover.util

/**
 * Create on 2022/4/7.
 *
 * @author wangshengguo.
 */

val String.signTime: String
    get() {
        return this.substring(0, 10)
    }