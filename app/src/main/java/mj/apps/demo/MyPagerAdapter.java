package mj.apps.demo;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = MyPagerAdapter.class.getSimpleName();
    private BaseFragmentViewPager currentFragment;
    private BaseFragmentViewPager selectedFragment;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: "+ position);
        switch (position) {
            case 0:
                selectedFragment = new CustomFragment();
                break;
            case 1:
                selectedFragment = new CustomFragment();
                break;
            case 2:
                selectedFragment = new CustomFragment();
                break;
        }
        return selectedFragment;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    public BaseFragmentViewPager getCurrentFragment(){
        return selectedFragment;
    }

    public BaseFragmentViewPager getFirstFragment(){
        return currentFragment;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((BaseFragmentViewPager) object);
        }
        super.setPrimaryItem(container, position, object);
    }
}
