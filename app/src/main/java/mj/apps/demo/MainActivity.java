package mj.apps.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;

import mj.apps.demo.fragments.FooFragment;
import mj.apps.demo.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    private SearchView searchView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.yourPlaceHolder, new FooFragment(), "FooFragment");
        fragmentTransaction.commit();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard, menu);
        MenuItem menuItem = menu.findItem(R.id.menuSeach);
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Log.d(TAG, "onMenuItemActionExpand: ");
                return true;
            }
            
            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Log.d(TAG, "onMenuItemActionCollapse: ");
                getSupportFragmentManager().popBackStack();
                return true;
            }
        });
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click search", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.yourPlaceHolder, new SearchFragment(), "SearchFragment");
                fragmentTransaction.addToBackStack("SearchFragment");
                fragmentTransaction.commit();
            }
        });
        
        return true;
    }
}
