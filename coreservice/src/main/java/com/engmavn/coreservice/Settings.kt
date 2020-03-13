package com.demo.coreservice

import com.demo.coreservice.BuildConfig.BASE_URL

class Settings{
    companion object{
        val DOMAIN_SERVER: String = BASE_URL //debug

        val URL_SERVER = "$DOMAIN_SERVER/"

        const val DEBUG = true
    }
}