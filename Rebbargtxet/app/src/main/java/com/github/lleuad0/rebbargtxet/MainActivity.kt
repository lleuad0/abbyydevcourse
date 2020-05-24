package com.github.lleuad0.rebbargtxet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val ID_KEY = "ID_KEY"

class MainActivity : AppCompatActivity(), NoteAdapter.Listener {

    override fun onNoteClick(noteId: Long) {
        val fragmentNoteContent = FragmentNoteContent()
        val bundle = Bundle()
        bundle.putLong(ID_KEY, noteId)
        fragmentNoteContent.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, fragmentNoteContent)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_holder, FragmentNotesList())
                .commit()
        }
    }

}
