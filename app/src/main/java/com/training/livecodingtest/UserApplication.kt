package com.training.livecodingtest

import android.app.Application
import com.training.livecodingtest.di.networkModules
import com.training.livecodingtest.di.repositoryModule
import com.training.livecodingtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UserApplication)
            androidLogger()
            modules(networkModules, repositoryModule, viewModelModule)
        }
    }
}