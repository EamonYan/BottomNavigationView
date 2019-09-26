package com.example.navigationview.iterator;

import com.example.navigationview.BottomTabItem;

import java.util.ArrayList;
import java.util.List;

public class TabListIterator<T extends BottomTabItem> implements TabIterator {
    List<T> mTabItems;
    int index = 0;
    public TabListIterator(){
        mTabItems = new ArrayList<>();
    }

    public void addItem(T item){
        mTabItems.add(item);
    }

    @Override
    public BottomTabItem next() {
        return mTabItems.get(index++);
    }

    @Override
    public boolean hashNext() {
        return index<mTabItems.size();
    }
}
