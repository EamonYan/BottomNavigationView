package com.example.navigationview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.navigationview.iterator.TabListIterator;
import com.example.navigationview.view.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BottomNavigationView mTabBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabBottomNavigation = findViewById(R.id.tab_bottom_navigation);

        TabListIterator iterator = new TabListIterator();

        iterator.addItem(new MainBottomTabItem.Builder(this).setText("item1").setIcon(R.drawable.tab_item_icon_src).create());
        iterator.addItem(new MainBottomTabItem.Builder(this).setText("item2").setIcon(R.drawable.tab_item_icon_src).create());
        iterator.addItem(new MainBottomTabItem.Builder(this).setText("item3").setIcon(R.drawable.tab_item_icon_src).create());
        iterator.addItem(new MainBottomTabItem.Builder(this).setText("item4").setIcon(R.drawable.tab_item_icon_src).create());

        mTabBottomNavigation.addTabItem(iterator);

        mTabBottomNavigation.setOnItemClickListener(new BottomNavigationView.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                Log.e(TAG,"itemClick--positiom="+position);
            }
        });

        mTabBottomNavigation.setCurrentItem(2);
    }
}
