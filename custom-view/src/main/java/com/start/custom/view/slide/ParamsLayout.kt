package com.start.custom.view.slide

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.FrameLayout

class ParamsLayout (context: Context, attrs: AttributeSet?, defStyleAttr: Int=0)
    : FrameLayout(context, attrs, defStyleAttr){
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)
    constructor(context: Context): this(context, null)

    private var lastX = 0F
    private var lastY = 0F

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = event.x
                lastY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val offsetX = (event.x - lastX).toInt()
                val offsetY = (event.y - lastY).toInt()
                val layoutParams = layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.leftMargin = left + offsetX
                layoutParams.topMargin = top + offsetY
                this.layoutParams = layoutParams
                lastX = event.x
                lastY = event.y
            }
            MotionEvent.ACTION_CANCEL -> {
                lastX = 0F
                lastY = 0F
            }
        }

        return true
    }
}