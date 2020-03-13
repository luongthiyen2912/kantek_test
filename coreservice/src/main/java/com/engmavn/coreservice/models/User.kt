package com.demo.coreservice.models

import com.demo.coreservice.data.local.AppDataManager
import com.demo.coreservice.models.base.ERespond
import com.demo.coreservice.utils.Constants
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    @Expose
    var id: String = "",
    @SerializedName("email")
    @Expose
    var email: String = "",

    @SerializedName("name")
    @Expose
    var name: String = "",

    @SerializedName("phone")
    @Expose
    var phone: String = "",

    @SerializedName("address")
    @Expose
    var address: String = "",

    @SerializedName("latitude")
    @Expose
    var latitude: String = "",

    @SerializedName("longitude")
    @Expose
    var longitude: String = "",

    @SerializedName("birthday")
    @Expose
    var birthday: String = "",
    @SerializedName("gender")
    @Expose
    var gender: Int = 0,
    @SerializedName("facebook_id")
    @Expose
    var facebookID: String = "",
    @SerializedName("google_id")
    @Expose
    var googleID: String = "",
    @SerializedName("device_token")
    @Expose
    var deviceToken: String = "",
    @SerializedName("cover")
    @Expose
    var cover: String = "",
    @SerializedName("type")
    @Expose
    var type: Int = 0,
    @SerializedName("receive_notification")
    @Expose
    var receiveNotification: Boolean = true,
    @SerializedName("access_token")
    @Expose
    var accessToken: String = "",
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String = "",
    @SerializedName("cover_url")
    @Expose
    var coverUrl: String = "",
    @SerializedName("friend_count")
    @Expose
    var friendCount: Int = 0,
    @SerializedName("follower_count")
    @Expose
    var followerCount: Int = 0,
    @SerializedName("review_count")
    @Expose
    var reviewCount: Int = 0,
    @SerializedName("check_in_count")
    @Expose
    var checkInCount: Int = 0,
    @SerializedName("media_count")
    @Expose
    var mediaCount: Int = 0,
    @SerializedName("friend_status")
    @Expose
    var friendStatus: String = "",
    @SerializedName("follow_status")
    @Expose
    var followStatus: Int = 0,
    @SerializedName("is_influence")
    @Expose
    var isInfluence: Boolean = false


) {

    class UserRespond : ERespond() {
        @SerializedName("data")
        @Expose
        var data: User? = null
            get() = field
    }

    companion object {
        fun clearLoginInfo() {
            val sharedPreferences =
                AppDataManager.getInstance().getUserPreference()
            sharedPreferences.edit().clear().apply()
            AppDataManager.getInstance().signedUser = null
        }

        fun saveUserInfo(userRespond: UserRespond) {
            val editor =
                AppDataManager.getInstance().getUserPreference().edit()
            val user = userRespond.data;
            user?.let {
                editor.putString(Constants.USER, Gson().toJson(user))
                AppDataManager.getInstance().signedUser = user
                editor.apply()
            }
        }



    }

}