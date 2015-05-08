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
import se.nackademin.examensarbete.eventbus.CatClickEvent;
import se.nackademin.examensarbete.handlers.ResourceHandler;
import se.nackademin.examensarbete.handlers.SaveLoadHandler;
import se.nackademin.examensarbete.presentation.game.GameFragment;
import se.nackademin.examensarbete.presentation.shop.ShopFragment;
import se.nackademin.examensarbete.presentation.statistic.StatisticFragment;
import timber.log.Timber;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;


public class MainActivity extends ActionBarActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private EventBus bus = EventBus.getDefault();
    private TextView scoreTextView;
    private GoogleApiClient googleApiClient;
    private static int RC_SIGN_IN = 9001;
    private boolean resolvingConnectionFailure = false;
    private boolean autoStartSignInflow = true;
    private boolean signInClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        bus.register(this);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API)
                .addScope(Games.SCOPE_GAMES)
                .build();
        SaveLoadHandler.LoadResourcehandler(this);
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

//    public void onEventMainThread(CatClickEvent event) {
//        Games.Achievements.unlock(googleApiClient, "CgkItpSbptAKEAIQAQ");
//    }

    private void startGameThread() {
        //new Thread(new GameThread()).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    protected void onPause() {
        SaveLoadHandler.SaveResourceHandler(this, ResourceHandler.getInstance());
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SaveLoadHandler.LoadResourcehandler(this);
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (resolvingConnectionFailure) {
            // already resolving
            return;
        }

        // if the sign-in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (signInClicked || autoStartSignInflow) {
            autoStartSignInflow = false;
            signInClicked = false;
            resolvingConnectionFailure = true;

            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign-in, please try again later."
            if (!BaseGameUtils.resolveConnectionFailure(this,
                    googleApiClient, connectionResult,
                    RC_SIGN_IN, "ERROR")) {
                resolvingConnectionFailure = false;
            }
        }
        // Put code here to display the sign-in button
    }
}
