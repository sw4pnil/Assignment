package com.test.assignment.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * @author swapnil-tml on 26-06-2020.
 * vertical spacing...decorator
 */

class VerticalSpacingItemDecorator(private val verticalSpaceHeight: Int) : ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        outRect.top = verticalSpaceHeight
    }
}