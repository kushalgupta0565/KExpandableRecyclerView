package com.hominoid.expandablerecyclerviewlib.listener

import com.hominoid.expandablerecyclerviewlib.models.ExpandableListItem

interface GroupExpandCollapseListener {
    fun onGroupExpanded(group: ExpandableListItem<*, *>?)
    fun onGroupCollapsed(group: ExpandableListItem<*, *>?)
}