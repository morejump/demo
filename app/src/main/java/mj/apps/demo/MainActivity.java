package mj.apps.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import mj.apps.demo.fragments.DemoFragment;
import mj.apps.demo.fragments.TestFragment;

public class MainActivity extends AppCompatActivity {
    
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
    
    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Override
        public Fragment getItem(int position) {
            return new DemoFragment();
        }
        
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "this is very fucking long title";
        }
        
        @Override
        public int getCount() {
            return 3;
        }
    }
    
    
}
