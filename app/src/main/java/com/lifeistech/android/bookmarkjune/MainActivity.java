package com.lifeistech.android.bookmarkjune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.memo_list);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //createボタンを押したらintentで新規作成画面に画面遷移
        if (R.id.main_create == id){
            Intent i = new Intent(MainActivity.this,MemoCreateActivity.class);
            startActivity(i);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();

        setMemoList();
    }


    //リストビューに表示する内容
    void setMemoList(){
        List<MemoDB> memoList = new Select().from(MemoDB.class).execute();
        ArrayAdapter<MemoDB> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.memo_row,
                memoList
        );
        mListView.setAdapter(adapter);
    }


}
