package com.example.ServiceDemoPlugin;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.huan.hhp.HwService;
import com.huan.hhp.HwServiceManager;
import com.huan.hhp.PluginApplication;
import com.huan.hhp.SimplePluginActivity;
import com.huan.hhp.app.ActivityInfo;
import com.huan.hhp.app.PluginInfo;
import com.huan.hhp.common.HHP;

public class MainActivity extends SimplePluginActivity {
    private boolean flag = true;
    private HwService hwService;
    TextView textView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText(""+msg.obj);
        }
    };
    public MainActivity(HHP openMeFrom, PluginInfo pluginInfo, ActivityInfo activityInfo) {
        super(openMeFrom, pluginInfo, activityInfo);
    }

    @Override
    public void onUiAfter() {
        textView = (TextView) findViewById("text");
        textView.setText("hello 111111");
        Log.i(MainActivity.class.getSimpleName(), "onUiAfter");
        HwServiceManager manager = (HwServiceManager) getPluginInfo().getApplication().getSystemService(PluginApplication.HW_SERVICE_MANAGER);
        Log.i(MainActivity.class.getSimpleName(), "manager="+manager);
        hwService = new HwService(manager){
            String TAG = "自定义服务";
            @Override
            protected void onCreate() {
                Log.i(TAG, "启动");
            }

            @Override
            protected void onRun() {
                Log.i(TAG, "onRun");
                while (flag){
                    Log.i(TAG, "system time:"+System.currentTimeMillis());
                    mHandler.sendMessage(mHandler.obtainMessage(0, System.currentTimeMillis()));
                    SystemClock.sleep(1000);
                }
            }

            @Override
            protected void onDestroy() {
                Log.i(TAG, "销毁");
            }
        };
        hwService.start(MainActivity.this);
        Log.i(MainActivity.class.getSimpleName(), "start service");

        Toast.makeText(getActivity(), "按左键跳转到新页面", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
        hwService.stop(MainActivity.this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT){
            startActivity("testGif");
        }
        return super.onKeyDown(keyCode, event);
    }
}
