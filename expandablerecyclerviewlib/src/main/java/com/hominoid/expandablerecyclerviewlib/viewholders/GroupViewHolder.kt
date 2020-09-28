package com.hominoid.expandablerecyclerviewlib.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hominoid.expandablerecyclerviewlib.listener.OnGroupClickListener

open class GroupViewHolder(itemView: View) : ViewHolder(itemView),
    View.OnClickListener {
    private var listener: OnGroupClickListener? = null
    override fun onClick(v: View) {
        if (listener != null) {
            listener!!.onGroupClick(adapterPosition)
        }
    }

    fun setOnGroupClickListener(listener: OnGroupClickListener?) {
        this.listener = listener
    }

    fun expand() {}
    fun collapse() {}

    init {
        itemView.setOnClickListener(this)
    }
}