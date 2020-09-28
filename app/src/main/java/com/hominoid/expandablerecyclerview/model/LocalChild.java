package com.hominoid.expandablerecyclerview.model;


import com.hominoid.expandablerecyclerviewlib.models.Child;

public class LocalChild extends Child {

    String childData;

    public LocalChild(String childData) {
        this.childData = childData;
    }

    public String getChildData() {
        return childData;
    }

    public void setChildData(String childData) {
        this.childData = childData;
    }
}
