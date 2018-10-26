package ken.dev.edulinkclassroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ChatResTabPagerAdapter extends FragmentPagerAdapter {

    private int numTabs;
    public ChatResTabPagerAdapter(FragmentManager fm, int noOfTabs){
        super(fm);
        this.numTabs = noOfTabs;
    }
    @Override
    public Fragment getItem(int pos){
        switch (pos){
            case 0 :
                //TODO: ChatFragment();
                return new UnitFragment();
            case 1 :{
                //TODO: ResourcesFragment();
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
