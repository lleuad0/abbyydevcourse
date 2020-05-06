package com.github.lleuad0.rebbargtxet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var manager: FragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager
        if (savedInstanceState == null) {
            manager.beginTransaction()
                .add(R.id.fragment_holder, FragmentNotesList())
                .commit()
        }
    }

}
