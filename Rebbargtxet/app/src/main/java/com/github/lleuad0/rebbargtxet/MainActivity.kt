package com.github.lleuad0.rebbargtxet

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.github.lleuad0.rebbargtxet.App.Companion.appResources

const val ID_KEY = "ID_KEY"
const val NOTE_BACKSTACK = "NOTE_BACKSTACK"

class MainActivity : AppCompatActivity(), NoteAdapter.Listener {

    override fun onNoteClick(noteId: Long) {
        val fragmentNoteContent = FragmentNoteContent()
        val bundle = Bundle()
        bundle.putLong(ID_KEY, noteId)
        fragmentNoteContent.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()

        if (isTabletInLandscape()) {

            // create or refresh a note fragment
            if (supportFragmentManager.findFragmentById(R.id.fragment_holder_note) == null) {
                transaction.add(R.id.fragment_holder_note, fragmentNoteContent)
            } else {
                supportFragmentManager.popBackStack(
                    NOTE_BACKSTACK,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                transaction.replace(R.id.fragment_holder_note, fragmentNoteContent)
            }

            // create a note fragment on phones and tablets in portrait
        } else {
            transaction.replace(R.id.fragment_holder_list, fragmentNoteContent)
        }

        transaction.addToBackStack(NOTE_BACKSTACK)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_holder_list, FragmentNotesList())
                .commit()
        }
    }

    companion object {
        fun isTabletInLandscape() =
            !appResources.getBoolean(R.bool.isPhone) &&
                    appResources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        fun isTabletInPortrait() =
            !appResources.getBoolean(R.bool.isPhone) &&
                    appResources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

}
