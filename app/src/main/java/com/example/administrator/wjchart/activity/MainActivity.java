package com.example.administrator.wjchart.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.wjchart.R;
import com.example.administrator.wjchart.adapter.MainAdapter;
import com.example.administrator.wjchart.fragment.ReadFragment;
import com.example.administrator.wjchart.fragment.UnReadFragment;

public class MainActivity extends FragmentActivity {


    private TextView mTime;
    private RadioButton mBtnUnread;
    private RadioButton mBtnRead;
    private FrameLayout mFragment;
    private TextView mTvTitle;
    private ListView mMainList;
    private Button mBtnCheck;
    private UnReadFragment unReadFragment;
    private ReadFragment readFragment;
    private int index;
    private Fragment[] fragments;
    private int currentTabIndex;
    public static MainActivity mainActivity;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        readFragment = new ReadFragment();
        unReadFragment = new UnReadFragment();
        fragments = new Fragment[] { readFragment, unReadFragment };
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, unReadFragment).show(unReadFragment).commit();
        assignViews();
        initView();
     }


    private void assignViews() {
        mTime = (TextView) findViewById(R.id.time);
        mBtnUnread = (RadioButton) findViewById(R.id.btn_unread);
        mBtnRead = (RadioButton) findViewById(R.id.btn_read);
        mFragment = (FrameLayout) findViewById(R.id.fragment);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mMainList = (ListView) findViewById(R.id.main_list);
        mBtnCheck = (Button) findViewById(R.id.btn_check);
    }

    private void initView() {

        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ChartActivity.class);
                startActivity(i);
            }
        });

        mBtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OnTabSelected(0);
            }
        });

        mBtnUnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OnTabSelected(1);
            }
        });
    }

    private void OnTabSelected(int i) {
        if (i == 0) {
            index = 0;
        }else if(i == 1){
            index = 1;
        }

        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        currentTabIndex = index;
    }


    public void refresh() {
        mAdapter = new MainAdapter(this);
        mMainList.setAdapter(mAdapter);
    }
}
