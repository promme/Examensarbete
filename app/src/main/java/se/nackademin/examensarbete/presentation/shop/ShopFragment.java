package se.nackademin.examensarbete.presentation.shop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.buildings.Building;
import se.nackademin.examensarbete.buildings.CatBreeder;
import se.nackademin.examensarbete.buildings.GoldMine;
import se.nackademin.examensarbete.buildings.LumberMill;
import se.nackademin.examensarbete.eventbus.UpdateUIEvent;
import se.nackademin.examensarbete.handlers.BuildingHandler;
import se.nackademin.examensarbete.handlers.ResourceHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private ArrayList<Building> buildings = new ArrayList<>();
    ListView shopListView;
    BuildingAdapter buildingAdapter;
    private EventBus bus = EventBus.getDefault();

    public ShopFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        setupBuildings();
        buildingAdapter = new BuildingAdapter(getActivity(), buildings);
        shopListView = (ListView) view.findViewById(R.id.shop_listview);
        shopListView.setAdapter(buildingAdapter);

        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Building b = (Building) buildingAdapter.getItem(position);
                if (canAffordBuilding(b)) {
                    buyBuilding(b);
                    new ParticleSystem(getActivity(), 10, R.drawable.ic_launcher, 3000)
                            .setSpeedByComponentsRange(-0.1f, 0.1f, -0.1f, 0.02f)
                            .setAcceleration(0.000003f, 90)
                            .setInitialRotationRange(0, 360)
                            .setRotationSpeed(120)
                            .setFadeOut(2000)
                            .addModifier(new ScaleModifier(0f, 1.5f, 0, 1500))
                            .oneShot(view, 8);
                } else {
                    Toast.makeText(getActivity(), "You cannot afford that", Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

    private void setupBuildings() {
        buildings.add(new GoldMine());
        buildings.add(new LumberMill());
        buildings.add(new CatBreeder());

    }

    private boolean canAffordBuilding(Building b) {
        if (ResourceHandler.getInstance().getNumberOfCats() >= b.getCatCost()
                && ResourceHandler.getInstance().getNumberOfStones() >= b.getStoneCost()
                && ResourceHandler.getInstance().getNumberOfLumber() >= b.getLumberCost()) {
            return true;
        }
        return false;

    }

    private void buyBuilding(Building b) {
        ResourceHandler.getInstance().subtractCats(b.getCatCost());
        ResourceHandler.getInstance().subtractStones(b.getStoneCost());
        ResourceHandler.getInstance().subtractLumber(b.getLumberCost());
        BuildingHandler.getInstance().addBuilding(b);
        bus.post(new UpdateUIEvent());
        buildingAdapter.notifyDataSetChanged();
    }
}
