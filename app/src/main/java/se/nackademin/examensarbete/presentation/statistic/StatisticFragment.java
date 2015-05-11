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

    private void initStatistics(){
        statisticList = new ArrayList<>();
        statisticList.add(new Statistic("Test", "Test 1"));
        statisticList.add(new Statistic("Test", "Test 2"));
        statisticList.add(new Statistic("Test", "Test 3"));
        statisticList.add(new Statistic("Test", "Test 4"));
        statisticList.add(new Statistic("Test", "Test 5"));
        statisticList.add(new Statistic("Test", "Test 6"));
        statisticList.add(new Statistic("Test", "Test 7"));
        statisticList.add(new Statistic("Test", "Test 8"));
        statisticList.add(new Statistic("Test", "Test 9"));
        statisticList.add(new Statistic("Test", "Test 10"));
        statisticList.add(new Statistic("Test", "Test 11"));
        statisticList.add(new Statistic("Test", "Test 12"));
        statisticList.add(new Statistic("Test", "Test 13"));
        statisticList.add(new Statistic("Test", "Test 14"));
        statisticList.add(new Statistic("Test", "Test 15"));
        statisticList.add(new Statistic("Test", "Test 16"));
        statisticList.add(new Statistic("Test", "Test 17"));
        statisticList.add(new Statistic("Test", "Test 18"));
        statisticList.add(new Statistic("Test", "Test 19"));
        statisticList.add(new Statistic("Test", "Test 20"));
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
        listView = (ListView)view.findViewById(R.id.statistic_listview);
        adapter = new StatisticListViewAdapter(statisticList, getActivity());
        listView.setAdapter(adapter);
        return view;
    }

    public void onEventMainThread(CatClickEvent event) {

    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO Uppdatera vyn från resurshanterarn
    }
}
