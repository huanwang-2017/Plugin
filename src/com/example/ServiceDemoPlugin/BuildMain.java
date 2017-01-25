package com.example.ServiceDemoPlugin;

import com.huan.builder.Builder;
import com.huan.builder.BuilderUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public class BuildMain {
    public static void main(String[] args) throws IOException {
        Builder.b("target/classes/ServiceDemoPlugin.apk", "D:\\Tomcat7\\webapps\\service-demo\\", "service-demo.zip", "res", "libs");
//        BuilderUtil.copyFile(new File("app_config.xml"), new File("D:\\Tomcat7\\webapps\\service-demo\\app_config.xml"));
    }
}
