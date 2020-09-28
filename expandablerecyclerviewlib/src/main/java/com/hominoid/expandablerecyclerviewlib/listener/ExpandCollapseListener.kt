package com.hominoid.expandablerecyclerviewlib.listener

interface ExpandCollapseListener {
    fun onGroupExpanded(positionStart: Int, itemCount: Int)
    fun onGroupCollapsed(positionStart: Int, itemCount: Int)
}