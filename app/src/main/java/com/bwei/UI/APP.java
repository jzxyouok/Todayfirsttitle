package com.bwei.UI;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by 葛凯旋 on 2017/7/18.
 */
public class APP extends Application {
    private  UMShareAPI umShareAPI;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        PlatformConfig.setQQZone("1106201745","mlOFmnJgnvn6zNxA");
       umShareAPI= UMShareAPI.get(this);
    }
    public  UMShareAPI  getumUmShareAPI(){
        return   umShareAPI;
    }
}
