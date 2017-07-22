package com.bwei.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.Fragment.ViedoFragment;
import com.bwei.Fragment.Home;
import com.bwei.Fragment.Weishenghuo;
import com.bwei.R;
import com.example.city_picker.CityListActivity;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar tab;
    private ImageView night;
    private int theme = R.style.AppTheme;


    private UMShareAPI api;
    private ImageView qq;
    private Button bcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_main);
        tab = (BottomTabBar) findViewById(R.id.bottom);

        addtab();


        // 创建菜单
        SlidingMenu menu = new SlidingMenu(this);
        // 设置菜单显示在左边
        menu.setMode(SlidingMenu.LEFT);
        // 设置菜单的触摸模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置菜单宽度
        menu.setBehindWidth(300);
        // 设置移动Activity的模式为Window
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        View view = View.inflate(this, R.layout.leftview, null);
        night = (ImageView) view.findViewById(R.id.night);
        bcity = (Button) view.findViewById(R.id.bcity);
        bcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CityListActivity.class));
//                CityListActivity.startCityActivityForResult(MainActivity.this);
            }
        });

        qq = (ImageView) view.findViewById(R.id.qq);
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APP app = (APP) getApplication();
                api = app.getumUmShareAPI();
                api.doOauthVerify(MainActivity.this, SHARE_MEDIA.QQ, um);
            }

            private UMAuthListener um = new UMAuthListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {

                }

                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    //  Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    api.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, um);
                    Set<String> keyset = map.keySet();
                    String iconurl = new String();
                    for (String string : keyset) {
                        if (string.equals("profile_image_url")) {
                            iconurl = map.get("profile_image_url");
                            Glide.with(getBaseContext()).load(iconurl).into(qq);
                        }
                    }
                }

                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {

                }
            };


        });
        menu.setMenu(view);
        yejian();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        api.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CityListActivity.REQUEST_CODE && resultCode == CityListActivity.RESULT_CODE) {
            String city = data.getStringExtra(CityListActivity.RESULT_KEY);
            bcity.setText(city);
        }
    }


    //夜间模式
    private void yejian() {
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = (theme == R.style.AppTheme) ? R.style.NightAppTheme : R.style.AppTheme;
                MainActivity.this.recreate();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }


    private void addtab() {
        tab.init(getSupportFragmentManager())
                .addTabItem("首页", R.drawable.home_tabbar_pressed, Home.class)
                .addTabItem("视频", R.drawable.play_movebar_textpage_pressed_night, ViedoFragment.class)
                .addTabItem("微头条", R.drawable.dynamic_tabbar_normal_night, Weishenghuo.class)
                .addTabItem("点赞", R.drawable.goodbule_details_dynamic_night, Home.class)
                .setImgSize(20, 20)
                .setFontSize(10);

    }
}
