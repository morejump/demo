package mj.apps.demo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mj.apps.demo.R;

public class TestFragment extends Fragment {
    
    public static TestFragment newInsance(String title) {
        Bundle bundle = new Bundle();
        bundle.putInt("thao handsome", 1);
        TestFragment testFragment = new TestFragment();
        testFragment.setArguments(bundle);
        return testFragment;
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
