package com.example.koreantime

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "KoreanTimeDatabase"
        private val TABLE_NAME = "user"
        private val KEY_NAME = "name"
        private val KEY_UNAME = "username"
        private val KEY_PWD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql: String = ("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                " (_id integer primary key autoincrement, "
                + KEY_NAME + " TEXT," + KEY_UNAME + " TEXT,"
                + KEY_PWD + " TEXT)")
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql: String = ("DROP TABLE IF EXISTS " + TABLE_NAME)

        db.execSQL(sql)
        onCreate(db)
    }
}