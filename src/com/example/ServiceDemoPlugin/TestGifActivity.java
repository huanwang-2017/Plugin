package com.example.ServiceDemoPlugin;

import com.huan.hhp.SimplePluginActivity;
import com.huan.hhp.app.ActivityInfo;
import com.huan.hhp.app.PluginInfo;
import com.huan.hhp.common.HHP;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class TestGifActivity extends SimplePluginActivity {

    private GifImageView gifView;

    private AsyncHttpClient asyncHttpClient;

    public TestGifActivity(HHP openMeFrom, PluginInfo pluginInfo, ActivityInfo activityInfo) {
        super(openMeFrom, pluginInfo, activityInfo);
    }

    @Override
    public void onUiAfter() {
        gifView = (GifImageView) findViewById("gifView");
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
                                gifView
                                        .setBackgroundDrawable(drawable);
                            }

                            @Override
                            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                            }

                        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
