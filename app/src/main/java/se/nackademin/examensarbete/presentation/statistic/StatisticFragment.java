package se.nackademin.examensarbete.presentation.statistic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.eventbus.UpdateUIEvent;
import se.nackademin.examensarbete.statistics.CatClickStatistics;
import se.nackademin.examensarbete.statistics.Statistic;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment {

    private List<Statistic> statisticList;
    private EventBus bus = EventBus.getDefault();
    private ListView listView;
    private StatisticListViewAdapter adapter;

    public StatisticFragment() {
        // Required empty public constructor
    }

    private void initStatistics() {
        statisticList = new ArrayList<>();
        statisticList.add(new CatClickStatistics());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus.register(this);
        initStatistics();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        listView = (ListView) view.findViewById(R.id.statistic_listview);
        adapter = new StatisticListViewAdapter(statisticList, getActivity());
        listView.setAdapter(adapter);
        return view;
    }

    public void onEventMainThread(CatClickEvent event) {
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
