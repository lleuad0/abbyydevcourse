package com.github.lleuad0.rebbargtxet

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        cardView.setOnClickListener {
            val intent = NoteContentActivity.getIntent(itemView.context, id)
            itemView.context.startActivity(intent)
        }
    }

    private val previewTextView = itemView.findViewById<TextView>(R.id.preview_text_view)
    private val dateTextView = itemView.findViewById<TextView>(R.id.date_text_view)
    private val previewImageView = itemView.findViewById<ImageView>(R.id.preview_image_view)
    private var id: Long = -1

    fun bind(note: Note) {
        previewTextView.text = note.text
        dateTextView.text = SimpleDateFormat().format(note.date)
        previewImageView.setImageResource(note.drawableRes)
        id = note.id
    }

}