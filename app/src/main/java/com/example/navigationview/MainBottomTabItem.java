package com.example.navigationview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainBottomTabItem extends BottomTabItem {
    private Builder mBuilder;
    private MainBottomTabItem(Context context, int layoutId){
        super(context,layoutId);
    }

    private MainBottomTabItem(Builder builder){
        super(builder.mContext,R.layout.tab_main_bottom_item);
        this.mBuilder = builder;
    }

    @Override
    protected void initLayout() {
        TextView text = getTabView().findViewById(R.id.tab_text);
        ImageView icon = getTabView().findViewById(R.id.tab_icon);
        if (!TextUtils.isEmpty(mBuilder.mText)){
            text.setText(mBuilder.mText);
        }

        if (mBuilder.mResIconId != 0){
            icon.setImageResource(mBuilder.mResIconId);
        }
    }

    @Override
    public void setSelected(boolean selected) {
        TextView text = getTabView().findViewById(R.id.tab_text);
        ImageView icon = getTabView().findViewById(R.id.tab_icon);
        getTabView().setSelected(selected);
        text.setSelected(selected);
        icon.setSelected(selected);
    }

    public static class Builder{
        Context mContext;
        String mText;
        int mResIconId;

        public Builder(Context context){
            this.mContext = context;
        }
        public Builder setText(String text){
            this.mText = text;
            return this;
        }

        public Builder setIcon(int resIconId){
            this.mResIconId = resIconId;
            return this;
        }

        public MainBottomTabItem create(){
            return new MainBottomTabItem(this);
        }
    }
}
