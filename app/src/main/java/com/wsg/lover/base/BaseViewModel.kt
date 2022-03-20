package com.wsg.lover.base

import androidx.lifecycle.ViewModel

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */

open class BaseViewModel : ViewModel() {
    protected val TAG = javaClass::class.java.simpleName

    override fun onCleared() {
        super.onCleared()
    }
}
