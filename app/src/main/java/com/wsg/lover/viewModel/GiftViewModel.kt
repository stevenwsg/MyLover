package com.wsg.lover.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.wsg.lover.base.BaseViewModel
import com.wsg.lover.bean.LoveGift
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */

private const val TAG = "BaseViewModel"

class GiftViewModel : BaseViewModel() {
    var gifts = MutableLiveData<LoveGift>()

    fun getGifts() {
        viewModelScope.launch(Dispatchers.IO) {
            val query = BmobQuery<LoveGift>()
            query.findObjects(object : FindListener<LoveGift>() {
                override fun done(p0: MutableList<LoveGift>?, p1: BmobException?) {
                    Log.d(TAG, "" + p0)
                    if (p1 == null) {
                        p0?.apply {
                            gifts.value = p1
                        }
                    }
                }
            })
        }
    }
}