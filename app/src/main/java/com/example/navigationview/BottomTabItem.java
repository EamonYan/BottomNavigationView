package com.example.navigationview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BottomTabItem {
    //布局id ,Context

    private View mTabItemView;

    private Context mContext;

    private int mLayoutId;

    public BottomTabItem(Context context, int layoutId) {
        this.mContext = context;
        this.mLayoutId = layoutId;
    }

    public View getTabView(){
        if (mTabItemView == null){
            mTabItemView = LayoutInflater.from(mContext).inflate(mLayoutId,null);
            initLayout();
        }
        return mTabItemView;
    }

    protected abstract void initLayout();

    protected  <T> T findViewById(int id){
        return (T)mTabItemView.findViewById(id);
    }
    /**
     * 是否选中
     * @param selected
     */
    public abstract void setSelected(boolean selected);
}
