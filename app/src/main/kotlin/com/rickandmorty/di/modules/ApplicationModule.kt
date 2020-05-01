package com.rickandmorty.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import com.rickandmorty.common.executors.PostExecutionThread
import com.rickandmorty.common.executors.UIThread
import com.rickandmorty.data.executors.ThreadExecutor
import com.rickandmorty.remote.executors.JobExecutor

@Module
abstract class ApplicationModule {

    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {
        /**
        @Provides
        @JvmStatic
        fun provideSomething(): Something {
        return InstanceOfSomething
        }*/
    }

    @Binds
    abstract fun bindApplicationContext(application: Application): Context

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread
}