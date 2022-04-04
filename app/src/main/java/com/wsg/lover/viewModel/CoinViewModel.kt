package com.wsg.lover.viewModel

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.UpdateListener
import com.wsg.lover.LoveApplication
import com.wsg.lover.base.BaseViewModel
import com.wsg.lover.bean.Coin
import com.wsg.lover.bean.MyCoin
import com.wsg.lover.util.SpHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Create on 2022/3/22.
 *
 * @author wangshengguo.
 */

private const val TAG = "CoinViewModel"

class CoinViewModel : BaseViewModel() {

    var coins = MutableLiveData<MutableList<Coin>>()
    val myCoin = MutableLiveData<Int>()

    var objectId = ""

    fun getCoins() {
        viewModelScope.launch(Dispatchers.IO) {
            val query = BmobQuery<Coin>()
            query.findObjects(object : FindListener<Coin>() {
                override fun done(p0: MutableList<Coin>?, p1: BmobException?) {
                    if (p1 == null) {
                        p0?.apply {
                            coins.postValue(this)
                        }
                    }
                }
            })
        }
    }

    fun getMyCoin() {
        viewModelScope.launch(Dispatchers.IO) {
            val query = BmobQuery<MyCoin>()
            query.findObjects(object : FindListener<MyCoin>() {
                override fun done(p0: MutableList<MyCoin>?, p1: BmobException?) {
                    if (p1 == null) {
                        p0?.apply {
                            objectId = p0[0].objectId
                            myCoin.postValue(p0[0].num)
                        }
                    }
                }
            })
        }
    }

    fun earnCoin(coin: Coin) {
        viewModelScope.launch(Dispatchers.IO) {
            val nCoin = MyCoin( myCoin.value!! + coin.num)

            try {
                nCoin.update(objectId, object : UpdateListener() {
                    override fun done(p0: BmobException?) {
                        if (p0 == null) {
                        myCoin.postValue(nCoin.num)
                        } else {
                            p0.printStackTrace()
                        }
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}