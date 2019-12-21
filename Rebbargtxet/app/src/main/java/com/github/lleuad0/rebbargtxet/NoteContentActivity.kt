package com.github.lleuad0.rebbargtxet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val ID_KEY = "ID_KEY"

class NoteContentActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, id: Long): Intent {
            val intent = Intent(context, NoteContentActivity::class.java)
            intent.putExtra(ID_KEY, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_content)
        title = getString(R.string.note_content_activity_title)

        val id = intent.getLongExtra(ID_KEY, -1)
        val note = NoteRepository.getNoteById(id)

        val imageView = findViewById<ImageView>(R.id.note_content_image_view)
        val textView = findViewById<TextView>(R.id.note_content_text_view)

        imageView.setImageResource(note?.drawableRes ?: android.R.color.darker_gray)
        textView.text = note?.text ?: getString(R.string.text_error_message)
        textView.movementMethod = ScrollingMovementMethod()
    }
}
