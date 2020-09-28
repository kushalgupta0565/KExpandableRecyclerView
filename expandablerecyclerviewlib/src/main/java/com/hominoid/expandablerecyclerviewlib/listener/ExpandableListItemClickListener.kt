package com.hominoid.expandablerecyclerviewlib.listener

interface ExpandableListItemClickListener {
    fun onGroupItemClick(position: Int)
    fun onChildItemClick(groupPosition: Int, childPosition: Int)
}