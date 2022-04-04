package com.wsg.lover.util

import android.content.Context

/**
 * Create on 2022/4/1.
 *
 * @author wangshengguo.
 */

private const val TAG = "SpHelper"
private const val KEY_COIN = "key_coin"
private const val KEY_MY_COIN_ID = "key_my_coin_id"

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

        fun saveMyCoinId(context: Context, coinId: String) {
            val sp = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            sp.apply {
                edit().putString(KEY_MY_COIN_ID, coinId).apply()
            }
        }

        fun getMyCoinId(context: Context): String {
            val sp = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
            return sp.getString(KEY_MY_COIN_ID, "") ?: ""
        }
    }
}