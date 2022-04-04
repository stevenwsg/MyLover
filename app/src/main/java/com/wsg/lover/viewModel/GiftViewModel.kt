package com.wsg.lover.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.UpdateListener
import com.wsg.lover.base.BaseViewModel
import com.wsg.lover.bean.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */

private const val TAG = "BaseViewModel"

class GiftViewModel : BaseViewModel() {
    var gifts = MutableLiveData<MutableList<LoveGift>>()

    var convertGiftResult = MutableLiveData<ConvertGiftResult>()

    fun getGifts() {
        viewModelScope.launch(Dispatchers.IO) {
            val query = BmobQuery<LoveGift>()
            query.findObjects(object : FindListener<LoveGift>() {
                override fun done(p0: MutableList<LoveGift>?, p1: BmobException?) {
                    Log.d(TAG, "" + p0)
                    if (p1 == null) {
                        p0?.apply {
                            gifts.postValue(this)
                        }
                    }
                }
            })
        }
    }

    fun convertGift(lastCoin: Int, objectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val myCoin = MyCoin(lastCoin)
            myCoin.update(objectId, object : UpdateListener() {
                override fun done(p0: BmobException?) {
                    if (p0 == null) {
                        convertGiftResult.postValue(ConvertGiftResult(RESULT_OK, lastCoin))
                    } else {
                        convertGiftResult.postValue(ConvertGiftResult(RESULT_FAIL, 0))
                    }
                }
            })
        }
    }
}