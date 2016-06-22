package com.lifeistech.android.bookmarkjune;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MemoCreateActivity extends AppCompatActivity {
    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_create);

        mTitle = (EditText) findViewById(R.id.create_title);
        mMemo = (EditText) findViewById(R.id.create_memo);
        mMemoDB = new MemoDB();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //saveボタンを押したら保存する
        if (R.id.create_save == id){
            saveMemo();
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //”保存する”の具体的な動作リスト
    void saveMemo(){
        //タイトル、本文を代入
        mMemoDB.title = mTitle.getText().toString();
        mMemoDB.memo = mMemo.getText().toString();
        //更新日時を代入
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoDB.date = sdf.format(date);
        //以上を保存する
        mMemoDB.save();
    }


}
