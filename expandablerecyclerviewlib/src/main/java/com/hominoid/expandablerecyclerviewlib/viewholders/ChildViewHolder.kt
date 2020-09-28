package com.hominoid.expandablerecyclerviewlib.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hominoid.expandablerecyclerviewlib.listener.OnGroupClickListener

open class ChildViewHolder(itemView: View) : ViewHolder(itemView),
    View.OnClickListener {
    private var listener: OnGroupClickListener? = null
    override fun onClick(v: View) {
        if (listener != null) {
            listener!!.onGroupClick(adapterPosition)
        }
    }

    fun setOnChildClickListener(listener: OnGroupClickListener?) {
        this.listener = listener
    }

    init {
        itemView.setOnClickListener(this)
    }
}