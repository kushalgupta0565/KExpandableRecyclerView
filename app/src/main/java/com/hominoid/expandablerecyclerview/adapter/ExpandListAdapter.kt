package com.hominoid.expandablerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.hominoid.expandablerecyclerview.R
import com.hominoid.expandablerecyclerview.adapter.ExpandListAdapter.ChildVH
import com.hominoid.expandablerecyclerview.adapter.ExpandListAdapter.ParentVH
import com.hominoid.expandablerecyclerview.model.LocalGroup
import com.hominoid.expandablerecyclerviewlib.adapter.ExpandableRecyclerViewAdapter
import com.hominoid.expandablerecyclerviewlib.listener.ExpandableListItemClickListener
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListItem
import com.hominoid.expandablerecyclerviewlib.viewholders.ChildViewHolder
import com.hominoid.expandablerecyclerviewlib.viewholders.GroupViewHolder
import com.hominoid.expandablerecyclerviewlib.viewholders.HeaderViewHolder

class ExpandListAdapter(
    var context: Context,
    groups: List<ExpandableListItem<*, *>>
) : ExpandableRecyclerViewAdapter<ParentVH, ChildVH>(groups), ExpandableListItemClickListener {

    override fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(View(parent.context))
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ParentVH {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.parent1, parent, false)
        return ParentVH(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildVH {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.child_1, parent, false)
        return ChildVH(view)
    }

    override fun onBindHeaderViewHolder(holder: HeaderViewHolder) {}

    override fun onBindGroupViewHolder(
        holder: ParentVH,
        groupIndex: Int,
        group: ExpandableListItem<*, *>
    ) {
        holder.textView.text = (group.groupData as LocalGroup).title
    }

    override fun onBindChildViewHolder(
        holder: ChildVH,
        groupIndex: Int,
        childIndex: Int,
        group: ExpandableListItem<*, *>
    ) {
        holder.textView.text = (group.groupData as LocalGroup).title + " child"
    }

    inner class ParentVH(itemView: View) :
        GroupViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.tv_parent_1)
        }
    }

    inner class ChildVH(itemView: View) :
        ChildViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.tv_child_1)
        }
    }

    override fun onChildItemClick(groupPosition: Int, childPosition: Int) {
        Toast.makeText(
            context,
            "onGroupItemClick " + groupPosition + "onChildItemClick " + childPosition,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onGroupItemClick(groupPosition: Int) {
        Toast.makeText(context, "onGroupItemClick $groupPosition", Toast.LENGTH_SHORT).show()
    }

    init {
        setExpandableListItemClickListener(this)
    }
}