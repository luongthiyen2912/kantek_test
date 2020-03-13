package com.demo.coreservice.utils

import android.text.TextUtils

class ObjectUtil {
  companion object{
      fun isNull(obj: Any?): Boolean {
          return obj == null
      }

      fun isEmptyStr(string: String?): Boolean {
          return TextUtils.isEmpty(string)
      }
  }
}