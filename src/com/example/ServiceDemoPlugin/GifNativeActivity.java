package com.example.ServiceDemoPlugin;

import android.app.Activity;
import android.os.Bundle;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
public class GifNativeActivity extends Activity {
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gifImageView=new GifImageView(this));
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient
                .get("http://cdn.duitang.com/uploads/item/201311/20/20131120213622_mJCUy.thumb.600_0.gif",
                        new AsyncHttpResponseHandler() {

                            @Override
                            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                                GifDrawable drawable = null;
                                try {
                                    drawable = new GifDrawable(bytes);
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                gifImageView.setImageDrawable(drawable);
                            }

                            @Override
                            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                            }

                        });
    }
}
