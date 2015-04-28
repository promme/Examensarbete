package se.nackademin.examensarbete.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jonkan on 2015-04-28.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int fragmentNumber) {
        return this.fragmentList.get(fragmentNumber);
    }

    @Override
    public int getCount() {
        return this.fragmentList.size();
    }
}
