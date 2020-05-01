package com.mobilechallenge

import android.app.Activity
import android.app.Application
import android.app.Service
import androidx.annotation.VisibleForTesting
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import com.mobilechallenge.di.AppInjector
import com.mobilechallenge.di.components.AppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasServiceInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var serviceInjector: DispatchingAndroidInjector<Service>
    private var realm: Realm? = null

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector
    override fun serviceInjector(): AndroidInjector<Service> = serviceInjector

    var appComponent: AppComponent = AppInjector.init(this)
        @VisibleForTesting
        set

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent.inject(this)
        realm = initRealm()
    }

    private fun initRealm(): Realm? {
        Realm.init(this)
        val realmConfiguration: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)

        return Realm.getDefaultInstance()
    }
}