package mj.apps.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    private PublishSubject<String> publishSubject;
    private CompositeDisposable compositeDisposable;
    private RecyclerView recyclerView;
    private EditText edtSearch;
    private RestClient restClient;
    private ResultAdapter resultAdapter;
    
    Function<String, List<String>> mapString = new Function<String, List<String>>() {
        @Override
        public List<String> apply(String s) throws Exception {
            return restClient.searchForCity(s);
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compositeDisposable = new CompositeDisposable();
        resultAdapter = new ResultAdapter(null);
        initViews();
        restClient = new RestClient(this);
        initObserbale();
        listenToSearchInput();
    }
    
    private void listenToSearchInput() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            
            }
            
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                publishSubject.onNext(charSequence.toString());
            }
            
            @Override
            public void afterTextChanged(Editable editable) {
            
            }
        });
    }
    
    private void initObserbale() {
        publishSubject = PublishSubject.create();
        publishSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .map(mapString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }
                    
                    @Override
                    public void onNext(List<String> results) {
                        handleSerchResults(results);
                    }
                    
                    @Override
                    public void onError(Throwable e) {
                    
                    }
                    
                    @Override
                    public void onComplete() {
                    
                    }
                });
        
    }
    
    
    private void handleSerchResults(List<String> results) {
        resultAdapter.setData(results);
    }
    
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(resultAdapter);
        edtSearch = findViewById(R.id.edtSearch);
        
    }
    
    private List<String> getColorList() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("color " + i);
        }
        return strings;
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
