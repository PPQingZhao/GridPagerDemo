package com.pp.gridpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pp.gridpager.adapter.GridPagerAdapter;
import com.pp.gridpager.snaphelp.GridPagerSnapHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initGridePager();
    }

    private void initGridePager() {
        int colum = 3;
        int row = 3;
        int orientation = GridLayoutManager.HORIZONTAL;
        int spanCount = (GridLayoutManager.VERTICAL == orientation) ? colum : row;

        // 设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), spanCount, orientation, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // 设置设配器
        GridPagerAdapter gridPagerAdapter = new GridPagerAdapter(getApplicationContext(), orientation, colum, row);
        mRecyclerView.setAdapter(gridPagerAdapter);

        //　设置页面滑动帮助类　sanaphelp
        GridPagerSnapHelper pagerSnapHelper = new GridPagerSnapHelper(colum, row);
        pagerSnapHelper.attachToRecyclerView(mRecyclerView);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.main_rl);
    }

}
