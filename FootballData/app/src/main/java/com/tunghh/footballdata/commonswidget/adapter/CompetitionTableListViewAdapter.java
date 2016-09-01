package com.tunghh.footballdata.commonswidget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.model.POJO.Table;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/26/2016.
 */
public class CompetitionTableListViewAdapter extends BaseAdapter {

    private ArrayList<Table.Standing> mTeams = new ArrayList<>();
    private Context mContext;

    public CompetitionTableListViewAdapter(Context context, ArrayList<Table.Standing> teams) {
        mTeams.addAll(teams);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mTeams.size();
    }

    @Override
    public Object getItem(int i) {
        return mTeams.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null || convertView.isActivated() == false){
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.shortstanding_listview_item, parent, false);
            return convertView;

        }else{
            return convertView;
        }
    }
}
