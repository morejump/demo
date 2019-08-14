package mj.apps.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * There are 2 Observables each emitting values after an interval of 100 ms and 150 ms
         * respectively. The combineLatest() operator combines both the observables and
         * emits the result at each particular intervals.
         
//         */
//        Observable<Long> observable1 = Observable.interval(2, TimeUnit.SECONDS);
//        Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS);
//
//        Observable.combineLatest(observable1, observable2,
//                (observable1Times, observable2Times) ->
//                        "Refreshed Observable1: " + observable1Times + " refreshed Observable2: " + observable2Times)
//                .subscribe(item -> System.out.println(item));
        String loginUserName = "morejump";
        
        Retrofit repo = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        
        Observable<JsonObject> observable = repo
                .create(GitHubUser.class)
                .getuser(loginUserName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        
        Observable<JsonArray> observable3 = repo
                .create(GitHubEvents.class)
                .listEvents(loginUserName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        
      Observable<UserAndEvents> userAndEventsObservable =  Observable.zip(observable, observable3, new BiFunction<JsonObject, JsonArray, UserAndEvents>() {
          @Override
          public UserAndEvents apply(JsonObject jsonObject, JsonArray jsonElements) throws Exception {
              return new UserAndEvents();
          }
      });
    }
}
