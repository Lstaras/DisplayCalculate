package com.example.caogl.displaycalculate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Entry> entryList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DisPlay");//toolbar的Title
        toolbar.setSubtitle("calculate");//toolbar的SubTitle
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,CalculateActivity.class);
                startActivity(intent);

            }
        });

        initEntry();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        EntryAdapter adapter = new EntryAdapter(entryList);
        recyclerView.setAdapter(adapter);

    }

    private void initEntry(){
        for (int i=0;i<20;i++)
        {
            Entry aaa = new Entry(R.drawable.aaa,"aaa","111");
            entryList.add(aaa);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_history:
                Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(intent);
                ;break;
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();break;
            case R.id.action_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();break;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    private long mPressedTime = 0;

    @Override
    public void onBackPressed() {
      long mNowTime = System.currentTimeMillis();//获取第一次按键时间
        if((mNowTime - mPressedTime) > 2000){//比较两次按键时间差
            Toast.makeText(this, "再次返回以退出应用~", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
    else{//退出程序
        this.finish();
        System.exit(0);
        }
    }

}
