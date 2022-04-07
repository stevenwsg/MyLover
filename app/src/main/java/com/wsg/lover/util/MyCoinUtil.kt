package com.wsg.lover.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Create on 2022/4/6.
 *
 * @author wangshengguo.
 */
class MyCoinUtil private constructor() {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            MyCoinUtil()
        }
    }

    var myCoin: Int by MyCoinDelegate()
}

class MyCoinDelegate : ReadWriteProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return SpHelper.getCoin(ActivityManager.instance.getTopActivity())
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        return SpHelper.saveCoin(ActivityManager.instance.getTopActivity(), value)
    }

}