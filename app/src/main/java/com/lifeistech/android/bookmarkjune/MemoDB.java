package com.lifeistech.android.bookmarkjune;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "memo_table")
public class MemoDB extends Model {

    @Column(name = "title")
    public String title;

    @Column(name = "memo")
    public String memo;

    @Column(name = "date")
    public String date;

    //各Columnを代表する値をタイトルに設定しておく
    @Override
    public String toString(){
        return title;
    }
}
