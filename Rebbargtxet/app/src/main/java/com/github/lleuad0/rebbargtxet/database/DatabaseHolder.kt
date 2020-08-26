package com.github.lleuad0.rebbargtxet.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.concurrent.locks.ReentrantLock

class DatabaseHolder(context: Context) {
    private val helper = AppSQLiteOpenHelper(context)
    private val reentrantLock = ReentrantLock()
    private var openInstances = 0
    private var sqLiteDatabase: SQLiteDatabase? = null

    fun open(): SQLiteDatabase{
        try {
            reentrantLock.lock()
            if (openInstances==0){
                sqLiteDatabase = helper.writableDatabase
            }
            openInstances++
            return sqLiteDatabase!!
        }
        finally {
            reentrantLock.unlock()
        }
    }

    fun close(){
        try {
            reentrantLock.lock()
            openInstances--
            if (openInstances==0){
                sqLiteDatabase?.close()
                sqLiteDatabase=null
            }
        }
        finally {
            reentrantLock.unlock()
        }
    }

}