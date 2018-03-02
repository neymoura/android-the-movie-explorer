package com.ghost.themovieexplorer.application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class TMEApplication : Application() {

    companion object {
        const val movieDBApiKey = "9fb1244aab053cf93fa00223bef8e80f"
    }

    override fun onCreate() {
        super.onCreate()

        setupRealm()

    }

    private fun setupRealm() {

        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .name("default.realm")
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(config)

    }

}