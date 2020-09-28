package com.hominoid.expandablerecyclerviewlib.models

open class Group<G> {
    var group: G? = null
        private set

    fun setGroup(group: G) {
        this.group = group
    }
}