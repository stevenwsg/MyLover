package com.wsg.lover.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.wsg.lover.base.BaseViewModel
import com.wsg.lover.bean.LoveContent
import com.wsg.lover.util.ConstantsLove
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */
private const val TAG = "LoveViewModel"

class LoveViewModel : BaseViewModel() {

    fun getLoves() {
        viewModelScope.launch(Dispatchers.IO) {
            val query = BmobQuery<LoveContent>()
            query.findObjects(object : FindListener<LoveContent>() {
                override fun done(p0: MutableList<LoveContent>?, p1: BmobException?) {
                    if (p1 == null) {
                        Log.d(TAG, "" + p0)
                        p0?.let {
                            ConstantsLove.setLove(p0[0])
                        }
                    }
                }
            })
        }
    }
}