package se.nackademin.examensarbete.presentation.statistic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment {

    private EventBus bus = EventBus.getDefault();
    private TextView clicks;
    int click = 0;

    public StatisticFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        clicks = (TextView)view.findViewById(R.id.statisticClicksTextview);
        return view;
    }

    public void onEventMainThread(CatClickEvent event){
        Timber.d("onEvent");
        click++;
        clicks.setText(""+click);
    }
}
