package ken.dev.edulinkclassroom;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;

public class HomeTabPagerAdapter extends FragmentPagerAdapter {
    private int numTabs;
    public HomeTabPagerAdapter(FragmentManager fm, int noOfTabs){
        super(fm);
        this.numTabs = noOfTabs;
    }
    @Override
    public Fragment getItem(int pos){
        switch (pos){
            case 0 :
                return new DashboardFragment();
            case 1 :{
                return new UnitFragment();
            }
            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return numTabs;
    }

}
