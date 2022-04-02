package com.wsg.lover.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.wsg.lover.base.BaseViewModel
import com.wsg.lover.bean.Coin
import com.wsg.lover.bean.MyCoin
import com.wsg.lover.util.SpHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Create on 2022/3/22.
 *
 * @author wangshengguo.
 */

private const val TAG = "CoinViewModel"

class CoinViewModel : BaseViewModel() {

    var coins = MutableLiveData<MutableList<Coin>>()
    val myCoin = MutableLiveData<MyCoin>()

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
                            myCoin.postValue(p0[0])
                        }
                    }
                }
            })
        }
    }

    fun earnCoin() {

    }

    fun updateMyCoin() {

    }

}