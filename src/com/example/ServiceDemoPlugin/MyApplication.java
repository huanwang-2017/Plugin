package com.example.ServiceDemoPlugin;

import android.content.Context;
import com.example.ServiceDemoPlugin.view.GifImageMapping;
import com.huan.hhp.PluginApplication;
import com.huan.hhp.widget.MappingTable;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class MyApplication extends PluginApplication {
    public MyApplication(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MappingTable.getSingleInstance().addMappingReference("GifImageView", GifImageMapping.class.getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MappingTable.getSingleInstance().removeMappingReference("GifImageView");
    }
}
