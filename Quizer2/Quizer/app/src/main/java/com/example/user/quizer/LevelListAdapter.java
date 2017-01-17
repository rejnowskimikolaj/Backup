package com.example.user.quizer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by RENT on 2017-01-17.
 */

public class LevelListAdapter extends ArrayAdapter {
    public LevelListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public LevelListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public LevelListAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    public LevelListAdapter(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public LevelListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public LevelListAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public void changeColor(int position){


    }
}
