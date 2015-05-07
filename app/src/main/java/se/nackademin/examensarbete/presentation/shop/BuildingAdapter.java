package se.nackademin.examensarbete.presentation.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.buildings.Building;

public class BuildingAdapter extends BaseAdapter {
    private ArrayList<Building> buildingList;
    Context context;

    public BuildingAdapter(Context context, ArrayList<Building> buildingList) {
        this.context = context;
        this.buildingList = buildingList;
    }

    public void setBuildingList(ArrayList<Building> buildingList) {
        this.buildingList = buildingList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return buildingList.size();
    }

    @Override
    public Object getItem(int position) {
        return buildingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;
        viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.building_adapter_row, null);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.amountTextView = (TextView) view.findViewById(R.id.amountTextView);
        viewHolder.costTextView = (TextView) view.findViewById(R.id.costTextView);
        viewHolder.nameTextView = (TextView) view.findViewById(R.id.buildingNameTextView);

        //TODO: Design
        viewHolder.amountTextView.setText("0");
        viewHolder.costTextView.setText(String.valueOf(buildingList.get(position).getCatCost()));
        viewHolder.nameTextView.setText(String.valueOf(buildingList.get(position).getName()));
        return view;
    }

    static class ViewHolder {
        TextView costTextView;
        TextView nameTextView;
        TextView amountTextView;
    }
}
