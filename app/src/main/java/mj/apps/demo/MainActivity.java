package mj.apps.demo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Single<List<Post>> observable = Client.getAPI().getPosts();
        Single<List<Photo>> observable1 = Client.getAPI().getPhotos();

        Single.zip(observable, observable1, (posts, photos) -> "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String aVoid) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    private void getData(List<Post> posts, List<Photo> photos) {

    }
}
