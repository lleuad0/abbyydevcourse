package com.github.lleuad0.rebbargtxet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var noteList: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface Listener {
        fun onNoteClick(noteId: Long)
    }
    lateinit var listener:Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(view, listener)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

}