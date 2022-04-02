package com.wsg.lover.util

import android.content.Context
import android.content.SharedPreferences


/**
 * Create on 2022/4/1.
 *
 * @author wangshengguo.
 */

private const val TAG = "SpHelper"
private const val KEY_COIN = "key_coin"

class SpHelper {
    companion object {

        fun saveCoin(context: Context, coin: Int) {
            val sp = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            sp.apply {
                edit().putInt(KEY_COIN, coin).apply()
            }
        }

        fun getCoin(context: Context): Int {
            val sp = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            return sp.getInt(KEY_COIN, 0)
        }
    }
}