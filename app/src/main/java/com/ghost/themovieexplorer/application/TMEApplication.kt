package com.ghost.themovieexplorer.application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class TMEApplication : Application(), ActivityLifecycleHandler.LifecycleListener {

    companion object {
        const val movieDBApiKey = "9fb1244aab053cf93fa00223bef8e80f"
    }

    override fun onCreate() {
        super.onCreate()
        setupRealm()
        registerActivityLifecycleCallbacks(ActivityLifecycleHandler(this))
    }

    private fun setupRealm() {

        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .name("default.realm")
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(config)

    }

    /**
     * Called right after the application has been started.
     */
    override fun onApplicationStarted() {

    }

    /**
     * Called right after the application has been resumed (come to the foreground).
     */
    override fun onApplicationResumed() {

    }

    /**
     * Called when the application is paused (but still awake).
     */
    override fun onApplicationPaused() {

    }

    /**
     * Called right before the application is stopped.
     */
    override fun onApplicationStopped() {
        Realm.getDefaultInstance()?.close()
    }

}