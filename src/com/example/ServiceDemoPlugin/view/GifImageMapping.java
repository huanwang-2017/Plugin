package com.example.ServiceDemoPlugin.view;

import android.content.Context;
import com.huan.hhp.widget.ViewMapping;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class GifImageMapping extends ViewMapping {
    {
        forTag(GifImageView.class.getName());
    }
    public GifImageMapping(Context context, String name) {
        super(context, name);
    }
}
