package com.demo.coreservice.data.local

import android.app.Application
import android.content.SharedPreferences

public interface AppDataMamangerRemote {

    fun setApplicationContext(application: Application)

    fun getUserPreference(): SharedPreferences?

    fun getAppSettingPreference(): SharedPreferences?
}