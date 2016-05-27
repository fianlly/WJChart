package com.example.administrator.wjchart.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.wjchart.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ReadFragment extends Fragment {

    private ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View createView = inflater.inflate(R.layout.fragment_read,container,false);
        mListView = (ListView) createView.findViewById(R.id.read_list);


        return createView;
    }
}
