package com.demo.coreservice.models.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class ERespond {
    @SerializedName("result")
    @Expose
    var result = false
    get() = field
    set(value){
        field = value
    }

    @SerializedName("message")
    @Expose
    var message: String = ""
        get() = field
        set(value){
            field = value
        }



}