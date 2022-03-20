package com.wsg.lover.util

import com.wsg.lover.bean.LoveContent

/**
 * Create on 2022/3/20.
 *
 * @author wangshengguo.
 */

class ConstantsLove {

    companion object {
        private var mlove: LoveContent? = null

        fun setLove(love: LoveContent) {
            mlove = love
        }

        fun getLove(): LoveContent? {
            return mlove
        }
    }

}