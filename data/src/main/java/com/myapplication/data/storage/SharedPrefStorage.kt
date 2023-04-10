package com.myapplication.data.storage

import android.content.Context
import com.myapplication.data.api.models.AutoLoginTokenResponse

private const val NAMETABLEPREF = "getSharedPrefs"
private const val TOKEN = "token"
private const val LOGIN = "login"
private const val FIRSTNAME = "firstname"
private const val LASTNAME = "lastname"


class SharedPrefStorage (context: Context):AutoLoginStorage{
    private val getPrefShared = context.getSharedPreferences(NAMETABLEPREF,Context.MODE_PRIVATE)
    override fun saveToken(token: String): Boolean {
        getPrefShared.edit().putString(TOKEN,token.toString()).apply()
        return true
    }

    override fun getToken(): String {
        val token =getPrefShared.getString(TOKEN, TOKEN) ?: TOKEN
        return token
    }

    override fun saveLoginAndInfo(tokenResponse: AutoLoginTokenResponse): Boolean {
        with(getPrefShared.edit()){
            putString(LOGIN,tokenResponse.login.toString())
            putString(FIRSTNAME,tokenResponse.firstname.toString())
            putString(LASTNAME,tokenResponse.lastname.toString())
        }
        return true
    }

    override fun getLoginAndInfo(): AutoLoginTokenResponse {
        val login = getPrefShared.getString(LOGIN, LOGIN)
        val firstName = getPrefShared.getString(FIRSTNAME, FIRSTNAME)
        val lastName = getPrefShared.getString(LASTNAME, LASTNAME)
        return AutoLoginTokenResponse(login = login, firstname = firstName, lastname = lastName)
    }


}