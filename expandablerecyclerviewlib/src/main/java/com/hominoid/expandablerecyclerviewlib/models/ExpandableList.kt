package com.hominoid.expandablerecyclerviewlib.models

import com.hominoid.expandablerecyclerviewlib.adapter.ExpandableRecyclerViewAdapter

class ExpandableList(
    var groups: List<ExpandableListItem<*, *>>
) {
    @JvmField
    var expandedGroupIndexes: BooleanArray
    private fun numberOfVisibleItemsInGroup(group: Int): Int {
        return if (expandedGroupIndexes[group]) {
            groups[group].itemCount + 1
        } else {
            1
        }
    }

    /**
     * @return the total number visible rows
     */
    val visibleItemCount: Int
        get() {
            var count = 0
            for (i in groups.indices) {
                count += numberOfVisibleItemsInGroup(i)
            }
            return count
        }

    fun getUnflattenedPosition(flPos: Int): ExpandableListPosition {
        var groupItemCount: Int
        var adapted = flPos
        for (i in groups.indices) {
            groupItemCount = numberOfVisibleItemsInGroup(i)
            if (adapted == 0) {
                return ExpandableListPosition.obtain(ExpandableListPosition.GROUP, i, -1, flPos)
            } else if (adapted < groupItemCount) {
                return ExpandableListPosition.obtain(
                    ExpandableListPosition.CHILD,
                    i,
                    adapted - 1,
                    flPos
                )
            }
            adapted -= groupItemCount
        }
        throw RuntimeException("Unknown state")
    }

    /**
     * @param listPosition representing either a child or a group
     * @return the index of a group within the [.getVisibleItemCount]
     */
    fun getFlattenedGroupIndex(listPosition: ExpandableListPosition): Int {
        val groupIndex = listPosition.groupPos
        var runningTotal = 0
        for (i in 0 until groupIndex) {
            runningTotal += numberOfVisibleItemsInGroup(i)
        }
        return runningTotal
    }

    /**
     * @param groupIndex representing the index of a group within [.groups]
     * @return the index of a group within the [.getVisibleItemCount]
     */
    fun getFlattenedGroupIndex(groupIndex: Int): Int {
        var runningTotal = 0
        for (i in 0 until groupIndex) {
            runningTotal += numberOfVisibleItemsInGroup(i)
        }
        return runningTotal
    }

    fun getFlattenedGroupIndex(group: ExpandableListItem<*, *>?): Int {
        val groupIndex = groups.indexOf(group)
        var runningTotal = 0
        for (i in 0 until groupIndex) {
            runningTotal += numberOfVisibleItemsInGroup(i)
        }
        return runningTotal
    }

    fun getFlattenedChildIndex(packedPosition: Long): Int {
        val listPosition =
            ExpandableListPosition.obtainPosition(packedPosition)
        return getFlattenedChildIndex(listPosition)
    }

    fun getFlattenedChildIndex(listPosition: ExpandableListPosition): Int {
        val groupIndex = listPosition.groupPos
        val childIndex = listPosition.childPos
        var runningTotal = 0
        for (i in 0 until groupIndex) {
            runningTotal += numberOfVisibleItemsInGroup(i)
        }
        return runningTotal + childIndex + 1
    }

    fun getFlattenedChildIndex(groupIndex: Int, childIndex: Int): Int {
        var runningTotal = 0
        for (i in 0 until groupIndex) {
            runningTotal += numberOfVisibleItemsInGroup(i)
        }
        return runningTotal + childIndex + 1
    }

    /**
     * @param groupIndex The index of a group within [.groups]
     * @return The flat list position for the first child in a group
     */
    fun getFlattenedFirstChildIndex(groupIndex: Int): Int {
        return getFlattenedGroupIndex(groupIndex) + 1
    }

    fun getFlattenedFirstChildIndex(listPosition: ExpandableListPosition): Int {
        return getFlattenedGroupIndex(listPosition) + 1
    }

    /**
     * @param listPosition An [ExpandableListPosition] representing either a child or group
     * @return the total number of children within the group associated with the @param listPosition
     */
    fun getExpandableGroupItemCount(listPosition: ExpandableListPosition): Int {
        return groups[listPosition.groupPos].itemCount
    }

    fun getExpandableGroup(listPosition: ExpandableListPosition): ExpandableListItem<*, *> {
        return groups[listPosition.groupPos]
    }

    init {
        expandedGroupIndexes = BooleanArray(groups.size)
        for (i in groups.indices) {
            expandedGroupIndexes[i] = false
        }
    }

    fun getExpandableListPosition(position: Int): ExpandableListPosition {
        val listPos: ExpandableListPosition
        if (ExpandableRecyclerViewAdapter.showHeaderView)
            listPos = getUnflattenedPosition(position - 1)
        else
            listPos = getUnflattenedPosition(position)
        return listPos
    }
}