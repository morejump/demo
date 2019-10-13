package mj.apps.demo;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public abstract class BaseFragmentViewPager extends Fragment {

    protected abstract TabLayout getTabLayout();

}
