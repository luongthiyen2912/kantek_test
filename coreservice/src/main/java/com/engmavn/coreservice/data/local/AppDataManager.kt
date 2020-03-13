package com.demo.coreservice.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Environment
import com.demo.coreservice.models.User
import com.demo.coreservice.utils.Constants
import com.demo.coreservice.utils.EUtils
import java.io.File

public class AppDataManager : AppDataMamangerRemote {
    companion object {
        const val PREF_USER_KEY = "PREF_USER_KEY"
        const val PREF_APP_SETTINGS_KEY = "PREF_APP_SETTINGS_KEY"
        const val PREF_APP_BUSINESS_KEY = "PREF_APP_BUSINESS_KEY"
        val ourInstance: AppDataManager = AppDataManager()
        fun getInstance(): AppDataManager = ourInstance
        fun init(application: Application) {
            getInstance().setApplicationContext(application)
        }
    }

    var signedUser: User ?= null

    private lateinit var appSettingPreference: SharedPreferences
    private lateinit var application: Application
    private lateinit var userPreference: SharedPreferences
    private lateinit var rootPath: String

    fun getContext(): Context = application
    override fun setApplicationContext(application: Application) {
        this.application = application
        rootPath =
            Environment.getExternalStorageDirectory().toString() + File.separator + EUtils.getApplicationName(
                application
            ) + File.separator

        userPreference = application.getSharedPreferences(
            PREF_USER_KEY,
            Context.MODE_PRIVATE
        )
        appSettingPreference = application.getSharedPreferences(
            PREF_APP_SETTINGS_KEY,
            Context.MODE_PRIVATE
        )
    }

    override fun getUserPreference(): SharedPreferences {
        return userPreference
    }

    override fun getAppSettingPreference(): SharedPreferences {
      return appSettingPreference
    }
}