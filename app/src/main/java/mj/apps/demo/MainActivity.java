package mj.apps.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<Long> observable = Observable.interval(100, TimeUnit.MILLISECONDS);
        Observable<Long> observable1 = Observable.interval(150, TimeUnit.MILLISECONDS);
        Observable.combineLatest(observable, observable1, (observable1Times, observable2Times) ->
                "Refreshed Observable1: " + observable1Times + " refreshed Observable2: " + observable2Times)
                .subscribe(item -> System.out.println(item));
        
        SingleObserver<Long> longObserver = new SingleObserver<Long>() {
            
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onSuccess(Long aLong) {
            
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
        };
    }
}
