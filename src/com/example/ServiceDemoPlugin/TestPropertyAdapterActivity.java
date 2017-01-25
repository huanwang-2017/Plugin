package com.example.ServiceDemoPlugin;

import android.content.Intent;
import android.widget.GridView;
import com.huan.hhp.SimplePluginActivity;
import com.huan.hhp.adapter.PropertyAdapter;
import com.huan.hhp.app.ActivityInfo;
import com.huan.hhp.app.PluginInfo;
import com.huan.hhp.common.HHP;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4 0004.
 */
public class TestPropertyAdapterActivity extends SimplePluginActivity {
    private GridView gridView;
    private PropertyAdapter<User> adapter;
    public TestPropertyAdapterActivity(HHP openMeFrom, PluginInfo pluginInfo, ActivityInfo activityInfo) {
        super(openMeFrom, pluginInfo, activityInfo);
    }

    @Override
    public void onCreate(Intent intent) {
        super.onCreate(intent);
        gridView = new GridView(getActivity());
        gridView.setNumColumns(2);
        String layoutString = "<LinearLayout><Button text=\"名称：${name} 性别：${sex}|${des}  ------- ${name} \" /></LinearLayout>";
        adapter = new PropertyAdapter<User>(getActivity(), layoutString, getPluginInfo());
        /*try {
            adapter = new PropertyAdapter<User>(getActivity(), new URL("http://172.10.10.211:8080/service-demo/test_property_adapter.xml").openStream(), getPluginInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        adapter.append(new User("张三", "23", "男", "张三hello"));
        adapter.append(new User("李四", "25", "男", "李四hello"));
        adapter.append(new User("王五", "22", "男", "王五hello"));
        adapter.append(new User("马六", "78", "男", "马六hello"));
        adapter.append(new User("照七", "13", "男", "照七hello"));
        gridView.setAdapter(adapter);
        setContentView(gridView);
    }
}
