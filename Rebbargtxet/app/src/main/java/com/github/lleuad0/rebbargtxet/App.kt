package com.github.lleuad0.rebbargtxet

import android.app.Application
import com.github.lleuad0.rebbargtxet.database.DatabaseHolder
import com.github.lleuad0.rebbargtxet.database.NoteRepository

class App : Application() {
    companion object {
        lateinit var noteRepository: NoteRepository
    }

    override fun onCreate() {
        super.onCreate()
        val databaseHolder = DatabaseHolder(this)
        noteRepository = NoteRepository(databaseHolder)
        noteRepository.generateNotes(this)
    }
}