package se.nackademin.examensarbete.presentation.statistic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Jonkan on 2015-04-29.
 */
public class StatisticListViewAdapter extends BaseAdapter {

    private List<String> statisticList;

    @Override
    public int getCount() {
        return statisticList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.statisticList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
