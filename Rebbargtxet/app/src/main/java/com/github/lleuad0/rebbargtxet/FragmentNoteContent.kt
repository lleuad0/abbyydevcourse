package com.github.lleuad0.rebbargtxet

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentNoteContent : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.note_content_title)
        return inflater.inflate(R.layout.fragment_note_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.note_content_image_view)
        val textView = view.findViewById<TextView>(R.id.note_content_text_view)

        val id = arguments?.getLong(ID_KEY) ?: -1
        val note = NoteRepository.getNoteById(id)

        imageView.setImageResource(note?.drawableRes ?: android.R.color.darker_gray)
        textView.text = note?.text ?: getString(R.string.text_error_message)
        textView.movementMethod = ScrollingMovementMethod()
    }
}