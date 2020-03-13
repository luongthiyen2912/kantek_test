package com.demo.test

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.demo.coreservice.data.local.AppDataManager
import com.demo.kotlinstructure.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasActivityInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun onCreate() {
        super.onCreate()
        initDagger()
        AppDataManager.init(this)
         }

    fun initDagger(){
        DaggerAppComponent.builder().build().inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}