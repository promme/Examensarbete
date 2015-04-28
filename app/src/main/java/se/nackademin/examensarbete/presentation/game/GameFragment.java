package se.nackademin.examensarbete.presentation.game;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.CatClickEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener {
    private final String TAG = getClass().getName();
    private Button catButton;
    private EventBus bus = EventBus.getDefault();

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        catButton = (Button) view.findViewById(R.id.game_kittenButton);
        catButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        CatClickEvent event = new CatClickEvent();
        bus.post(event);
    }
}
