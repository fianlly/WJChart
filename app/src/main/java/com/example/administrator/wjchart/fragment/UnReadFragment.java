package com.example.administrator.wjchart.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.wjchart.R;
import com.example.administrator.wjchart.activity.MainActivity;
import com.example.administrator.wjchart.adapter.UnReadAdapter;

/**
 * Created by Administrator on 2016/5/26.
 */
public class UnReadFragment extends Fragment{

    private ListView mListView;
    private UnReadAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View createView = inflater.inflate(R.layout.fragment_unread,container,false);
        mListView = (ListView) createView.findViewById(R.id.unread_list);
        mAdapter = new UnReadAdapter(getActivity());
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.mainActivity.refresh();
            }
        });
        return createView;
    }
}
