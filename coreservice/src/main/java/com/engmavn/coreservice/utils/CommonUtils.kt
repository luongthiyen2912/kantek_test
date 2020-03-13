package com.demo.coreservice.utils

import okhttp3.internal.and
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CommonUtils {
    companion object {
        fun hashPasswodSHA256(password : String): String {
            val bytes = password.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }
}