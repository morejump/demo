package mj.apps.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public Observer<Integer> getFirstObserver() {
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "first onSubscribe: ");
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "first onNext: " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
//                Log.d(TAG, "onError: ");
            }
            
            @Override
            public void onComplete() {
//                Log.d(TAG, "first onComplete: ");
            }
        };
        
        return integerObserver;
    }
    
    public Observer<Integer> getSecondObserver() {
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "second onSubscribe: ");
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "second onNext: " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
//                Log.d(TAG, "second onError: ");
            }
            
            @Override
            public void onComplete() {
//                Log.d(TAG, "second onComplete: ");
            }
        };
        return integerObserver;
    }
    
}
