package se.nackademin.examensarbete.presentation.score;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.handlers.ResourceHandler;


public class ScoreFragment extends Fragment {

    private EventBus bus = EventBus.getDefault();
    private TextView treesTextView;
    private TextView stonesTextView;
    private TextView catsTextView;

    public ScoreFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        treesTextView = (TextView) view.findViewById(R.id.treesResourceNumber);
        stonesTextView = (TextView) view.findViewById(R.id.stoneResourceNumber  );
        catsTextView = (TextView) view.findViewById(R.id.catsResourceNumber);
        return view;
    }

    public void onEventMainThread(CatClickEvent event) {
    treesTextView.setText(String.valueOf(ResourceHandler.getInstance().getNumberOfTrees()));
    stonesTextView.setText(String.valueOf(ResourceHandler.getInstance().getNumberOfStones()));
    catsTextView.setText(String.valueOf(ResourceHandler.getInstance().getNumberOfCats()));
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
