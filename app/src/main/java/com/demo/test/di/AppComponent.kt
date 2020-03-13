package com.demo.kotlinstructure.di

import com.demo.test.App
import com.demo.test.di.DataModule
import com.demo.test.di.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule:: class,AppModule :: class,  DataModule::class, ActivityModuleBuilder :: class, ViewModelModule:: class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
    fun inject(app: App)
}