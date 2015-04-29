package se.nackademin.examensarbete.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.List;
import java.util.Vector;

import de.greenrobot.event.EventBus;
import se.nackademin.examensarbete.R;
import se.nackademin.examensarbete.presentation.game.GameFragment;
import se.nackademin.examensarbete.presentation.shop.ShopFragment;
import se.nackademin.examensarbete.presentation.statistic.StatisticFragment;
import timber.log.Timber;


public class MainActivity extends ActionBarActivity {

    private final String TAG = getClass().getName();
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private EventBus bus = EventBus.getDefault();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.plant(new Timber.DebugTree());
        //Fullscreen, remove the statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        setupFragments();

    }

    private void setupFragments(){
        List<Fragment> fragmentList = new Vector<Fragment>();
        fragmentList.add(Fragment.instantiate(this, ShopFragment.class.getName()));
        fragmentList.add(Fragment.instantiate(this, GameFragment.class.getName()));
        fragmentList.add(Fragment.instantiate(this, StatisticFragment.class.getName()));
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager = (ViewPager) findViewById(R.id.fragment_viewpager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
