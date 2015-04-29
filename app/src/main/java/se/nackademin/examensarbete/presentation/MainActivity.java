package se.nackademin.examensarbete.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;
import java.util.Vector;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.handlers.ResourceHandler;
import se.nackademin.examensarbete.handlers.SaveLoadHandler;
import se.nackademin.examensarbete.presentation.game.GameFragment;
import se.nackademin.examensarbete.presentation.shop.ShopFragment;
import se.nackademin.examensarbete.presentation.statistic.StatisticFragment;
import timber.log.Timber;


public class MainActivity extends ActionBarActivity {

    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private EventBus bus = EventBus.getDefault();
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Planting Timber tree for logging
        Timber.plant(new Timber.DebugTree());
        //Fullscreen, remove the statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Setup fragments
        setupGameLayout();
        //must be after gameLayout
        startGameThread();
        //Admob
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void setupGameLayout() {
        List<Fragment> fragmentList = new Vector<>();
        fragmentList.add(Fragment.instantiate(this, ShopFragment.class.getName()));
        fragmentList.add(Fragment.instantiate(this, GameFragment.class.getName()));
        fragmentList.add(Fragment.instantiate(this, StatisticFragment.class.getName()));
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager = (ViewPager) findViewById(R.id.fragment_viewpager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(2);

    }

    private void startGameThread() {
        //new Thread(new GameThread()).start();
    }

    @Override
    protected void onPause() {
        SaveLoadHandler.SaveResourceHandler(this, ResourceHandler.getInstance());
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ResourceHandler.setResourceHandler(SaveLoadHandler.LoadResourcehandler(this));
    }
}
