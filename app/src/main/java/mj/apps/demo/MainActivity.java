package mj.apps.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Observable.just(1, 2, 3, 4, 5, 6).buffer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }
            
            @Override
            public void onNext(List<Integer> integers) {
                Log.d(TAG, "onNext: " + integers.toString());
            }
            
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }
            
            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        
        // hello CI
        
    }
    
}
