package com.hominoid.expandablerecyclerviewlib.listener

import android.view.View
import android.view.ViewGroup
import com.hominoid.expandablerecyclerviewlib.viewholders.HeaderViewHolder

interface HeaderViewHolderCallback {

    fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder
    fun onBindHeaderViewHolder(holder: HeaderViewHolder)
}