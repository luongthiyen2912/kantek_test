package com.demo.coreservice.utils

import android.content.Context
import android.text.TextUtils
import android.util.Patterns


class EUtils {
    companion object{
        fun getApplicationName(context: Context) : String{
            val stringId = context.applicationInfo.labelRes
            return context.getString(stringId)
        }
        fun isValidEmail(target: CharSequence?): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }
    }
}