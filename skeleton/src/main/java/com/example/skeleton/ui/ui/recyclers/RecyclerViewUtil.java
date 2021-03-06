package com.example.skeleton.ui.ui.recyclers;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-15
 */

public class RecyclerViewUtil {

    public static <K extends BaseAdapter> void initDefaultRecycler(RecyclerView recyclerView, Context context, K adapter) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
