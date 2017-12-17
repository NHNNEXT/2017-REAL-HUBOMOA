package com.amigotrip.android.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.support.v7.preference.PreferenceManager
import android.support.v7.preference.PreferenceScreen
import android.widget.Toast
import com.amigotrip.android.AmigoApplication
import com.amigotrip.android.UserInfoManager
import com.amigotrip.android.activities.NewArticleActivity
import com.amigotrip.android.activities.StartActivity
import com.amigotrip.android.datas.User
import com.amigotrip.android.remote.AmigoService
import com.amigotrip.anroid.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Zimincom on 2017. 11. 20..
 */
class MainPreferenceFragment : PreferenceFragmentCompat(), PreferenceManager
.OnPreferenceTreeClickListener,PreferenceFragmentCompat.OnPreferenceStartScreenCallback{

    lateinit var amigoService: AmigoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference)

        amigoService = (context.applicationContext as AmigoApplication).component.service()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        if (preference.key == "pref_profile") {

        } else if (preference.key == "pref_logout") {
            signOut()
        } else if (preference.key == "pref_new_article" ) {

            val call = amigoService.loginUser(UserInfoManager.getLogineduser())

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>?, response: Response<User>) {

                    if (response.isSuccessful) {
                        val intent = Intent(context, NewArticleActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<User>?, t: Throwable?) {
                    t?.printStackTrace()
                    Toast.makeText(context, "sorry, something went wrong", Toast.LENGTH_SHORT).show()
                }
            })
        }

        return true
    }

    private fun signOut() {

        UserInfoManager.removeUser()

        startActivity(Intent(activity, StartActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }


    override fun onPreferenceStartScreen(caller: PreferenceFragmentCompat?, pref: PreferenceScreen?): Boolean {
        caller?.setPreferenceScreen(pref)
        return true
    }
}