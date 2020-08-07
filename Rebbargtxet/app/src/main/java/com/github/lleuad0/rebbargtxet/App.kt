package com.github.lleuad0.rebbargtxet

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        NoteRepository.initialize(this)
    }
}