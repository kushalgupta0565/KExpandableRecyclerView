package com.hominoid.expandablerecyclerviewlib.models

open class Child<C> {
    var c: C? = null
        private set

    fun setC(c: C) {
        this.c = c
    }
}