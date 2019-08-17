package mj.apps.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = getColorList();
        Observable<List<String>> observable = Observable.just(list);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(List<String> strings) {
                Log.d(TAG, "onNext: " + Thread.currentThread());
                Log.d(TAG, "onNext: " + strings);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        });
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
    
    private List<String> getColorList() {
        Log.d(TAG, "getColorList: " + Thread.currentThread());
        List<String> strings = new ArrayList<>();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            strings.add(i + "");
        }
        
        return strings;
        
    }
    
}
