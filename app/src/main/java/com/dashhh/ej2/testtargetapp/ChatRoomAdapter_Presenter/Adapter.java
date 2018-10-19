/*
 * Copyright (c) 2018
 */

package com.dashhh.ej2.testtargetapp.ChatRoomAdapter_Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dashhh.ej2.testtargetapp.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {

    private static final String TAG = "Main Room List";
    ArrayList<Set> data = new ArrayList<>();
    Context mContext;

    public Adapter(ArrayList<Set> data, Context mContext) {
        this.mContext = mContext;

        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.adapter_chatroom, parent, false);
        return new Holder(v);
}

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final int i = position;

        Set getData = data.get(position);

//        Log.i(TAG, "holder.liveParticipants.setText(getData.participants) > " + getData.roomID);

    }

    @Override
    public int getItemViewType(int position) {
        Log.d("방송자채팅어댑터", "Adapter > getItemViewType()");
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        Log.d("방송자채팅어댑터", "Adapter > getItemCount()");
        return data.size();
    }
}
