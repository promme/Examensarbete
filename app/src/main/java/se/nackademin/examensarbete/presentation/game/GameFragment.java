package se.nackademin.examensarbete.presentation.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.AchivementEvent;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.eventbus.CheckAchivementsEvent;
import se.nackademin.examensarbete.eventbus.LeaderboardEvent;
import se.nackademin.examensarbete.handlers.ResourceHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener {

    private ImageButton catButton;
    private Button signin, achivements, leaderboards;
    private EventBus bus = EventBus.getDefault();
    private Chronometer chronometer;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        chronometer = (Chronometer) view.findViewById(R.id.clock);
        catButton = (ImageButton) view.findViewById(R.id.game_kittenButton);
        signin = (Button) view.findViewById(R.id.signInButton);
        achivements = (Button) view.findViewById(R.id.achivementButton);
        achivements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAchivementsEvent checkAchivementsEvent = new CheckAchivementsEvent();
                bus.post(checkAchivementsEvent);
            }
        });
        leaderboards = (Button) view.findViewById(R.id.leaderBoardsButton);
        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeaderboardEvent event = new LeaderboardEvent();
                bus.post(event);
            }
        });

        catButton.setOnClickListener(this);
        setupChronometer();
        return view;
    }

    private void setupChronometer() {
        chronometer.start();
    }

    @Override
    public void onClick(View v) {

        new ParticleSystem(getActivity(), 10, R.drawable.star, 3000)
                .setSpeedByComponentsRange(-0.1f, 0.1f, -0.1f, 0.02f)
                .setAcceleration(0.000003f, 90)
                .setInitialRotationRange(0, 360)
                .setRotationSpeed(120)
                .setFadeOut(2000)
                .addModifier(new ScaleModifier(0f, 1.5f, 0, 1500))
                .oneShot(v, 1);
        ResourceHandler.getInstance().addCats(1);
        CatClickEvent event = new CatClickEvent();
        bus.post(event);
    }
}
