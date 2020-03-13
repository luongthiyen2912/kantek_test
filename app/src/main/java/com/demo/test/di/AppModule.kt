

package com.demo.kotlinstructure.di
import android.app.Application
import android.content.Context
import com.demo.coreservice.data.local.LocalRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideLocalRepository(): LocalRepository {
        return LocalRepository()
    }
    @Provides
    @Singleton
    fun provideContext(application: Application) : Context{
        return application
    }
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.Main
    }
}
