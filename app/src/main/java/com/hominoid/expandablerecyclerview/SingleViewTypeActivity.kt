package com.hominoid.expandablerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.hominoid.expandablerecyclerview.adapter.ExpandListAdapter
import com.hominoid.expandablerecyclerview.adapter.MultiViewExpandListAdapter
import com.hominoid.expandablerecyclerview.model.LocalChild
import com.hominoid.expandablerecyclerview.model.LocalGroup
import com.hominoid.expandablerecyclerviewlib.models.ExpandableListItem
import java.util.*

class SingleViewTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        val listData: MutableList<ExpandableListItem<LocalGroup, LocalChild>> =
            ArrayList()
        val stringList: MutableList<LocalChild> =
            ArrayList<LocalChild>()
        stringList.add(LocalChild("Child 1"))
        stringList.add(LocalChild("Child 2"))
        stringList.add(LocalChild("Child 3"))
        stringList.add(LocalChild("Child 4"))
        val group = LocalGroup()
        group.setTitle("Titlr 1")
        val sample = ExpandableListItem(group, stringList)
        listData.add(sample)
        val group2 = LocalGroup()
        group2.setTitle("Title 2 with no child")
        val sample2 = ExpandableListItem<LocalGroup, LocalChild>(group2, null)
        listData.add(sample2)
        val group3 = LocalGroup()
        group3.setTitle("Title 3")
        val sample3 = ExpandableListItem(group3, stringList)
        listData.add(sample3)
        val group4 = LocalGroup()
        group4.setTitle("Title 4")
        val sample4 = ExpandableListItem(group4, stringList)
        listData.add(sample4)
        val group5 = LocalGroup()
        group5.setTitle("Title 5")
        val sample5 = ExpandableListItem(group5, stringList)
        listData.add(sample5)
        val group6 = LocalGroup()
        group6.setTitle("Title 6")
        val sample6 = ExpandableListItem(group6, stringList)
        listData.add(sample6)
        ///////////////////////////////////
        ///////////////////////////////////
        val group7 = LocalGroup()
        group7.setTitle("Title 7")
        val sample7 = ExpandableListItem(group7, stringList)
        listData.add(sample7)
        ////////////////////////////////////
        ////////////////////////////////////
        val group8 = LocalGroup()
        group8.setTitle("Title 8")
        val sample8 = ExpandableListItem(group8, stringList)
        listData.add(sample8)
        val adapter = ExpandListAdapter(this, listData)
        recycler_view.adapter = adapter
    }



}
