package com.github.lleuad0.rebbargtxet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentNotesList : Fragment(), NoteAdapter.Listener {

    override fun onNoteClick(noteId: Long) {
        (activity as? MainActivity)?.onNoteClick(noteId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.notes_list_title)
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.setHasFixedSize(true)
        recyclerView.recycledViewPool.setMaxRecycledViews(0, 8)

        val noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter
        noteAdapter.noteList = NoteRepository.getNotesList()
        noteAdapter.listener = this
    }
}