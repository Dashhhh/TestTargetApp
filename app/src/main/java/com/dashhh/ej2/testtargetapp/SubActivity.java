package com.dashhh.ej2.testtargetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.dashhh.ej2.testtargetapp.ChatRoomAdapter_Presenter.Adapter;
import com.dashhh.ej2.testtargetapp.ChatRoomAdapter_Presenter.Set;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    private Adapter recyclerAdapter;
    private ArrayList<Set> recyclerSet = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);



    }



    public void adap() {


        Set setData = new Set(


        );
        recyclerSet.add(setData);
        recyclerAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(recyclerSet.size() - 1);


    }
}
