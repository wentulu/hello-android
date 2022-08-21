package com.start.custom.view.slide

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.Scroller

class ScrollerLayout(context: Context, attributeSet: AttributeSet?, style: Int)
    : FrameLayout(context, attributeSet, style) {
    constructor(context: Context, attributeSet: AttributeSet?):this(context, attributeSet, 0)
    constructor(context: Context) :this(context,null)


    private val mScroller = Scroller(context)


    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            (parent as View).scrollTo(mScroller.currX, mScroller.currY)
            invalidate()
        }
    }


    fun smoothScrollTo(destX: Int, destY:Int) {
        val scrollX = scrollX
        val delta = destX - scrollX
        mScroller.startScroll(scrollX, 0, delta, 0, 2000)
        invalidate()
    }

}