package com.amigotrip.android

import android.content.Context
import android.content.SharedPreferences
import com.amigotrip.android.datas.User
import com.amigotrip.anroid.R

/**
 * Created by Zimincom on 2017. 11. 16..
 */
object UserInfoManager {

    private lateinit var preference: SharedPreferences
    private lateinit var user: User

    fun initManager(context: Context) {
        preference = context.getSharedPreferences(context.getString(R.string.KEY_PREFERENCE),
                Context.MODE_PRIVATE)
    }

    fun setUserInfo(user: User?) {
        val editor = preference.edit()
        editor.putInt(AppKeys.userId, user!!.id!!)
        editor.putString(AppKeys.userName, user.name)
        editor.putString(AppKeys.userEmail, user.email)
        editor.putBoolean(AppKeys.isLogin, true)
        editor.apply()

        this.user = user!!
    }

    fun getPreference() = preference

    fun isUserLogin() : Boolean {
        return preference.getBoolean(AppKeys.isLogin, false)
    }

    fun removeUser() {
        preference.edit().clear().apply()
    }

    fun getLogineduser(): User{
        val name = preference.getString(AppKeys.userName, "no name")
        val email = preference.getString(AppKeys.userEmail, "no email")

        return User(name = name, email = email, id = null, profileImg = "")
    }


}