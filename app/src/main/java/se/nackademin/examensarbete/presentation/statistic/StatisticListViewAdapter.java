package se.nackademin.examensarbete.presentation.statistic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.statistics.Statistic;

/**
 * Created by Jonkan on 2015-04-29.
 */
public class StatisticListViewAdapter extends BaseAdapter {

    private List<Statistic> statisticList;
    private Context mContext;

    public StatisticListViewAdapter(List<Statistic> statisticList, Context mContext) {
        this.statisticList = statisticList;
        this.mContext = mContext;
    }

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
        View view;
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.statistic_adapter_row, parent, false);
            holder = new ViewHolder();
            holder.statisticName = (TextView) view.findViewById(R.id.nameStatisticText);
            holder.statisticValue = (TextView) view.findViewById(R.id.valueStatisticText);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.statisticName.setText(statisticList.get(position).getStatisticsName());
        holder.statisticValue.setText(statisticList.get(position).getStatisticsValue());
        return view;
    }

    public static class ViewHolder {
        TextView statisticName;
        TextView statisticValue;
    }
}
