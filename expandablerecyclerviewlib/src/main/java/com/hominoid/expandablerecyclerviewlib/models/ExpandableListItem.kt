package com.hominoid.expandablerecyclerviewlib.models

class ExpandableListItem<G : Group<*>?, C : Child<*>?>(
    var groupData: G,
    var childDataList: List<C>?
) {

    val itemCount: Int
        get() = if (childDataList == null) 0 else childDataList!!.size

}