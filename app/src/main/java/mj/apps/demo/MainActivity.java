package mj.apps.demo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import mj.apps.demo.fragments.FirstFragment;
import mj.apps.demo.fragments.SecondFragment;
import mj.apps.demo.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_bottom_first:
                        loadFragment(new FirstFragment());
                        break;
                    case R.id.nav_bottom_second:
                        loadFragment(new SecondFragment());
                        break;
                    case R.id.nav_bottom_third:
                        loadFragment(new ThirdFragment());
                        break;
                    
                }
                return false;
            }
        });
        
    }
    
    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmnetHolder, fragment);
        fragmentTransaction.commit();
    }
}
