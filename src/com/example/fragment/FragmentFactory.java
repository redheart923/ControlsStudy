package com.example.fragment;


import android.app.Fragment;



/**
 * Created by admin on 13-11-23.
 */
public class FragmentFactory {
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case 1:
                fragment = new GridViewMenu_fragment();
                break;
            case 2:
                fragment = new FamilyHonFragment();
                break;
            case 3:
                fragment = new SaleFragment();
                break;
            case 4:
                fragment = new HappyLifeFragment();
                break;
            case 5:
                fragment = new PointADsFragment();
                break;
            case 6:
                fragment = new SearchFragment();
                break;
        }
        return fragment;
    }
}
