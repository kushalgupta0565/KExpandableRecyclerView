package com.hominoid.expandablerecyclerviewlib.utils

import com.hominoid.expandablerecyclerviewlib.listener.ExpandCollapseListener
import com.hominoid.expandablerecyclerviewlib.models.ExpandableList
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListItem
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListPosition

class ExpandCollapseController(
    private val expandableList: ExpandableList,
    private val listener: ExpandCollapseListener?
) {
    private fun collapseGroup(listPosition: ExpandableListPosition) {
        expandableList.expandedGroupIndexes[listPosition.groupPos] = false
        listener?.onGroupCollapsed(
            expandableList.getFlattenedGroupIndex(listPosition) + 1,
            expandableList.groups[listPosition.groupPos].itemCount
        )
    }

    /**
     * Expand a group
     *
     * @param listPosition the group to be expanded
     */
    private fun expandGroup(listPosition: ExpandableListPosition) {
        expandableList.expandedGroupIndexes[listPosition.groupPos] = true
        listener?.onGroupExpanded(
            expandableList.getFlattenedGroupIndex(listPosition) + 1,
            expandableList.groups[listPosition.groupPos].itemCount
        )
    }

    fun isGroupExpanded(group: ExpandableListItem<*, *>?): Boolean {
        val groupIndex = expandableList.groups.indexOf(group)
        return expandableList.expandedGroupIndexes[groupIndex]
    }

    /**
     * @param flatPos the flattened position of an item in the list
     * @return true if `group` is expanded, false if it is collapsed
     */
    fun isGroupExpanded(flatPos: Int): Boolean {
        val listPosition = expandableList.getExpandableListPosition(flatPos)
        return expandableList.expandedGroupIndexes[listPosition.groupPos]
    }

    fun toggleGroup(flatPos: Int): Boolean {
        val listPos = expandableList.getExpandableListPosition(flatPos)
        val expanded = expandableList.expandedGroupIndexes[listPos.groupPos]
        if (expanded) {
            collapseGroup(listPos)
        } else {
            expandGroup(listPos)
            if (listPos.groupPos == expandableList.groups.size) { // Scroll one child item
            }
        }
        return expanded
    }

    fun toggleGroup(group: ExpandableListItem<*, *>?): Boolean {
        val listPos =
            expandableList.getExpandableListPosition(expandableList.getFlattenedGroupIndex(group))
        val expanded = expandableList.expandedGroupIndexes[listPos.groupPos]
        if (expanded) {
            collapseGroup(listPos)
        } else {
            expandGroup(listPos)
            if (listPos.groupPos == expandableList.groups.size) { // Scroll one child item
            }
        }
        return expanded
    }

}