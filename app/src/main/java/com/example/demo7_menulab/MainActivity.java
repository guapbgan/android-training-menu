package com.example.demo7_menulab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.imageView));
        registerForContextMenu(findViewById(R.id.textView));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.menu1, menu);


        //利用 res xml方法
        switch (v.getId()){
            case R.id.textView:
                getMenuInflater().inflate(R.menu.context1, menu);
                break;
            case R.id.imageView:
                getMenuInflater().inflate(R.menu.context2, menu);
                break;

        }


        //program 中加入item的法
//        switch (v.getId()){
//            case R.id.textView:
//                menu.setHeaderTitle("text Context Menu");
//                break;
//            case R.id.imageView:
//                menu.setHeaderTitle(("image Context Menu"));
//        }
////        menu.setHeaderTitle("Context Menu");
//        menu.add(0, 0, 1, "context menu1");
//        menu.add(0, 1, 2, "context menu2"); //新add的item可在此指定id，然後再到onContextItemSelected的getItemId()去判斷點誰
////        menu.add("context menu1").getItemId();
////        menu.add("context menu2");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Toast.makeText(this, "menu1 is clicked", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this, "menu2 is clicked", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView = findViewById(R.id.textView);
        switch (item.getItemId()){
            case R.id.menu1:
                textView.setText("menu1 clicked");
                break;
            case R.id.menu2:
                textView.setText("menu2 clicked");
                break;
                //meanu3可以點，但是他彈出子選單，所以不用有後續
            case R.id.menu4:
                textView.setText("menu4 clicked");
                break;
            case R.id.menu5:
                textView.setText("menu5 clicked");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}