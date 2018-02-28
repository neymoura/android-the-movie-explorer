package com.ghost.themovieexplorer.view.custom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

class TMERecyclerView : RecyclerView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    var emptyView: View? = null

    private val emptyObserver = object : RecyclerView.AdapterDataObserver() {

        override fun onChanged() {

            adapter?.let {
                when (adapter.itemCount) {
                    0 -> {
                        emptyView?.visibility = View.VISIBLE
                        this@TMERecyclerView.visibility = View.GONE
                    }
                    else -> {
                        emptyView?.visibility = View.GONE
                        this@TMERecyclerView.visibility = View.VISIBLE
                    }
                }
            }

        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)

        adapter?.registerAdapterDataObserver(emptyObserver)
        emptyObserver.onChanged()

    }

}