package com.github.lleuad0.rebbargtxet

import android.app.Application
import android.content.res.Resources


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        NoteRepository.initialize(this)
        appResources = this.resources
    }

    companion object {
        lateinit var appResources: Resources
    }
}