/*
 * Copyright (c) 2018
 */

package com.dashhh.ej2.testtargetapp.ChatRoomAdapter_Presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dashhh.ej2.testtargetapp.R;

public class Holder extends RecyclerView.ViewHolder {

    TextView ownerName, repoName, repoDescription, repoStarCount;
    ImageView ownerAvatarImage;

    public Holder(View itemView) {
        super(itemView);

        ownerAvatarImage = itemView.findViewById(R.id.ownerAvatarImage);
        ownerName = itemView.findViewById(R.id.ownerName);
        repoName = itemView.findViewById(R.id.repoName);
        repoDescription = itemView.findViewById(R.id.repoDescription);
        repoStarCount = itemView.findViewById(R.id.repoStarCount);
    }
}
