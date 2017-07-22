package com.bwei.UI;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.bwei.Bean.Downbean;
import com.bwei.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 葛凯旋 on 2017/7/21.
 */
public class Download extends AppCompatActivity {
    private List<Downbean> list=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.download);
        adddata();
    }

         private void adddata() {
          for (int i = 0; i < 30; i++) {
          Downbean  down=new Downbean(false,"推荐"+i);
            list.add(down);
        }

    }
}
