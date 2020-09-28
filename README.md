# ExpandableRecyclerView

## Add Dependencies

In Project Gradle

```bash
allprojects {
    repositories {
        ..
        ..
        maven { url 'https://jitpack.io' }
    }
}
```

In app Gradle add
```bash
	implementation 'com.github.kushalgupta0565:KExpandableRecyclerView:1.0.0'
```


## Models/Pojo Class Creation

Model for Group Item should extend Group

```bash
public class LocalGroup extends Group {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
```

Model for Child Item should extend Child

```bash
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
```

## ViewHolders Creation

For Group items:
```bash
    class ParentVH extends GroupViewHolder {

        TextView textView;

        public ParentVH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);

        }
    }

```

For Child Items:
```bash
    class ChildVH extends ChildViewHolder {

        TextView textView;

        public ChildVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
```


## Expandable RecyclerView Adapter Creation

```bash
    public class ExpandListAdapter extends ExpandableRecyclerViewAdapter<ParentVH, ChildVH>
		implements ExpandableListItemClickListener {
        	...
		...
		...
		...
    }
```

## Expandable Multiple ViewType RecyclerView Adapter Creation

```bash
    public class MultipleViewTypeExpandListAdapter extends MultiViewTypeExpandaleAdapter<GroupViewHolder, ChildViewHolder>
		implements ExpandableListItemClickListener {
        	...
		...
		...
		...
    }
```



## Setting the adapter from Activity/Fragment

```bash
RecyclerView recycler_view = findViewById(R.id.recycler_view);
List<ExpandableListItem> listData = new ArrayList<>();
..
..
..
..
ExpandListAdapter adapter = new ExpandListAdapter(listData);
recycler_view.setAdapter(adapter);
```





