package com.github.lleuad0.rebbargtxet.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.github.lleuad0.rebbargtxet.Note
import com.github.lleuad0.rebbargtxet.R
import java.util.*

class NoteRepository(private val databaseHolder: DatabaseHolder) {

    fun generateNotes(context: Context) {
        for (i in 0..11) {
            val note = Note(
                i.toLong(),
                Calendar.getInstance().time,
                context.resources.getString(R.string.note_content_sample),
                getFakeDrawable(i)
            )
            saveNote(note)
        }
    }

    fun saveNote(note: Note) {
        try {
            val database = databaseHolder.open()

            val contentValues = ContentValues()
            contentValues.put(NoteTableHelper.Columns.DATE, note.date.time)
            contentValues.put(NoteTableHelper.Columns.TEXT, note.text)
            contentValues.put(NoteTableHelper.Columns.DRAWABLE_RES, note.drawableRes)

            database.insert(TABLE_NAME, null, contentValues)
        } finally {
            databaseHolder.close()
        }
    }

    fun getNotesList(): MutableList<Note> {
        val notesList: MutableList<Note> = mutableListOf()
        var cursor: Cursor? = null
        try {
            val database = databaseHolder.open()

            cursor = database.query(
                TABLE_NAME,
                NoteTableHelper.Columns.noteColumns,
                null, null, null, null, null
            )

            while (cursor.moveToNext()) {
                val note = getNoteFromCursor(cursor)
                notesList.add(note)
            }
        } finally {
            cursor?.close()
            databaseHolder.close()
            return notesList
        }
    }

    fun getNoteById(id: Long): Note? {
        var cursor: Cursor? = null
        var note: Note? = null
        try {
            val database = databaseHolder.open()

            cursor = database.query(
                TABLE_NAME,
                NoteTableHelper.Columns.noteColumns,
                "${NoteTableHelper.Columns._ID} = ?",
                arrayOf(id.toString()),
                null, null, null
            )

            while (cursor.moveToNext()) {
                note = getNoteFromCursor(cursor)
            }
        } finally {
            cursor?.close()
            databaseHolder.close()
            return note
        }
    }

    private fun getNoteFromCursor(cursor: Cursor): Note {
        val id = cursor.getInt(cursor.getColumnIndex(NoteTableHelper.Columns._ID)).toLong()
        val date = Date(
            cursor.getLong(cursor.getColumnIndex(NoteTableHelper.Columns.DATE))
        )
        val text = cursor.getString(cursor.getColumnIndex(NoteTableHelper.Columns.TEXT))
        val drawableRes =
            cursor.getInt(cursor.getColumnIndex(NoteTableHelper.Columns.DRAWABLE_RES))
        return Note(id, date, text, drawableRes)
    }

    private fun getFakeDrawable(index: Int) =
        when (index) {
            1, 6 -> R.drawable.fake_drawable_1
            2, 7 -> R.drawable.fake_drawable_2
            3, 8 -> R.drawable.fake_drawable_3
            4, 9 -> R.drawable.fake_drawable_4
            5, 10 -> R.drawable.fake_drawable_5
            else -> R.drawable.note_content_image
        }
}

