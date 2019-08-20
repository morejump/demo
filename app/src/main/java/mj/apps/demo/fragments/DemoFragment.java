package mj.apps.demo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mj.apps.demo.R;

public class DemoFragment extends Fragment {
    public static final String INTEGER_KEY = "INTEGER_KEY";
    
    public static DemoFragment newInstance() {
        DemoFragment demoFragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putInt(INTEGER_KEY, 1);
        demoFragment.setArguments(args);
        return demoFragment;
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int dataInteger = getArguments().getInt(INTEGER_KEY);
            
        }
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_foo, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
