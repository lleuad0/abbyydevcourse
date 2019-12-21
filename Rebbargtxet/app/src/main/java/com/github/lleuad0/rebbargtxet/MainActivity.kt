package com.github.lleuad0.rebbargtxet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.main_activity_title)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.recycledViewPool.setMaxRecycledViews(0, 5)

        val noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter
        noteAdapter.noteList = NoteRepository.getNotesList()
    }

}
