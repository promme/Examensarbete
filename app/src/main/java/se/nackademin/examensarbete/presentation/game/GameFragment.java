package se.nackademin.examensarbete.presentation.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.handlers.ResourceHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener {

    private ImageButton catButton;
    private EventBus bus = EventBus.getDefault();

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        catButton = (ImageButton) view.findViewById(R.id.game_kittenButton);
        catButton.setOnClickListener(this);
        return view;
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
