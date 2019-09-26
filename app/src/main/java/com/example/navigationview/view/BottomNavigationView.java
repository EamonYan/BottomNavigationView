package com.example.navigationview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.navigationview.BottomTabItem;
import com.example.navigationview.iterator.TabIterator;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationView extends LinearLayout {
    private List<BottomTabItem> mTabItems;
    private int mCurrentIndex = -1;
    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener{
        public void itemClick(int position);
    }
    public BottomNavigationView(Context context) {
        this(context,null);
    }

    public BottomNavigationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomNavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        mTabItems = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener;
    }

    public void addTabItem(TabIterator iterator){
        mTabItems.clear();
        int index = 0;
        while(iterator.hashNext()){
            BottomTabItem tabItem = iterator.next();
            View tabView = tabItem.getTabView();
            addView(tabView);

            LinearLayout.LayoutParams params = (LayoutParams) tabView.getLayoutParams();
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            tabView.setLayoutParams(params);

            //给条目设置点击事件

            setItemClickListener(tabView,index++);
            mTabItems.add(tabItem);
        }

        mTabItems.get(0).setSelected(true);
        mCurrentIndex = 0;
    }

    private void setItemClickListener(View tabView, final int index) {
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex != index){
                    mTabItems.get(mCurrentIndex).setSelected(false);
                    mTabItems.get(index).setSelected(true);
                    mCurrentIndex =index;
                    if (mItemClickListener != null){
                        mItemClickListener.itemClick(mCurrentIndex);
                    }
                }
            }
        });
    }

    public void setCurrentItem(int index){
        if (index < mTabItems.size() && mCurrentIndex != index){
            mTabItems.get(mCurrentIndex).setSelected(false);
            mTabItems.get(index).setSelected(true);
            mCurrentIndex = index;
        }
    }
}
