package com.hominoid.expandablerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hominoid.expandablerecyclerview.R
import com.hominoid.expandablerecyclerviewlib.adapter.MultiViewTypeExpandaleAdapter
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListItem
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListPosition
import com.hominoid.expandablerecyclerviewlib.viewholders.ChildViewHolder
import com.hominoid.expandablerecyclerviewlib.viewholders.GroupViewHolder
import com.hominoid.expandablerecyclerviewlib.viewholders.HeaderViewHolder

class HeaderMultiViewExpandListAdapter(
    var context: Context,
    groups: List<ExpandableListItem<*, *>>
) : MultiViewTypeExpandaleAdapter<GroupViewHolder, ChildViewHolder>(groups, true) {

    override fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
        return HeaderVH(view)
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        if (viewType == 11) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.parent1, parent, false)
            return Parent1VH(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.parent2, parent, false)
            return Parent2VH(view)
        }
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        if (viewType == 1111) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.child_1, parent, false)
            return Child1VH(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.child_2, parent, false)
            return Child2VH(view)
        }
    }

    override fun onBindHeaderViewHolder(holder: HeaderViewHolder) {


    }

    override fun onBindGroupViewHolder(
        holder: GroupViewHolder,
        groupIndex: Int,
        group: ExpandableListItem<*, *>
    ) {
        if (holder is Parent1VH) {
            holder.tv_parent_1.text = "Parent 1 design at position $groupIndex"
        } else if (holder is Parent2VH) {
            holder.tv_parent_2.text = "Parent 2 design at position $groupIndex"
        }
    }

    override fun onBindChildViewHolder(
        holder: ChildViewHolder,
        groupIndex: Int,
        childIndex: Int,
        group: ExpandableListItem<*, *>
    ) {
        if (holder is Child1VH) {
            holder.tv_child_1.text = "Child 1 design at Child position $childIndex"
        } else if (holder is Child2VH) {
            holder.tv_child_2.text = "Child 2  design at Child position $childIndex"
        }
    }

    override fun getGroupViewType(position: Int, group: ExpandableListItem<*, *>): Int {
        if (position == 0) {
            return 11
        } else {
            return 21
        }
    }

    override fun getChildViewType(
        position: Int,
        group: ExpandableListItem<*, *>,
        childIndex: Int
    ): Int {
        if (childIndex == 0) {
            return 1111
        } else {
            return 2111
        }
    }

    inner class HeaderVH(itemView: View) : HeaderViewHolder(itemView) {
        var tv_header: TextView

        init {
            tv_header = itemView.findViewById(R.id.tv_header)
        }
    }

    inner class Parent1VH(itemView: View) : GroupViewHolder(itemView) {
        var tv_parent_1: TextView

        init {
            tv_parent_1 = itemView.findViewById(R.id.tv_parent_1)
        }
    }

    inner class Parent2VH(itemView: View) : GroupViewHolder(itemView) {
        var tv_parent_2: TextView

        init {
            tv_parent_2 = itemView.findViewById(R.id.tv_parent_2)
        }
    }

    inner class Child1VH(itemView: View) :
        ChildViewHolder(itemView) {
        var tv_child_1: TextView

        init {
            tv_child_1 = itemView.findViewById(R.id.tv_child_1)
        }
    }

    inner class Child2VH(itemView: View) :
        ChildViewHolder(itemView) {
        var tv_child_2: TextView

        init {
            tv_child_2 = itemView.findViewById(R.id.tv_child_2)
        }
    }

    override fun isGroup(viewType: Int): Boolean {
        return viewType == 11 || viewType == 21
    }

    override fun isChild(viewType: Int): Boolean {
        return viewType == 1111 || viewType == 2111
    }
}