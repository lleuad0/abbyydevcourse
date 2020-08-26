package com.github.lleuad0.rebbargtxet.database

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

const val TABLE_NAME = "notes_table"

object NoteTableHelper {

    object Columns : BaseColumns {
        const val _ID = BaseColumns._ID
        const val DATE = "date"
        const val TEXT = "text"
        const val DRAWABLE_RES = "drawable_res"

        val noteColumns = arrayOf(
            _ID, DATE, TEXT, DRAWABLE_RES
        )
    }

    fun createTable(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE $TABLE_NAME" +
                    " ( " +
                    "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.DATE} BLOB NOT NULL," +
                    "${Columns.TEXT} TEXT NON NULL," +
                    "${Columns.DRAWABLE_RES} INTEGER NOT NULL" +
                    ");"
        )
    }
}