package com.github.lleuad0.rebbargtxet

import android.content.Context
import java.util.*

object NoteRepository {

    private val notesList: MutableMap<Long, Note> = hashMapOf()

    fun initialize(context: Context) {
        for (i in 0..11) {
            val long = i.toLong()
            notesList[long] =
                Note(
                    long,
                    Calendar.getInstance().time,
                    context.resources.getString(R.string.note_content_sample),
                    getFakeDrawable(i)
                )
        }
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

    fun getNotesList(): List<Note> = notesList.values.toList()

    fun getNoteById(id: Long): Note? = notesList[id]

}

