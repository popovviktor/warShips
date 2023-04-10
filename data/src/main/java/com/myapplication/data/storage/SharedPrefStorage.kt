package com.myapplication.data.storage

import android.content.Context
import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.models.AutoLoginTokenResponse

private const val NAMETABLEPREF = "getsharedprefs"
private const val TOKEN = "token"
private const val LOGIN = "login"
private const val FIRSTNAME = "firstname"
private const val LASTNAME = "lastname"
private const val DEFAULT = ""


class SharedPrefStorage (context: Context):AutoLoginStorage{
    private val getPrefShared = context.getSharedPreferences(NAMETABLEPREF,Context.MODE_PRIVATE)
    override fun saveToken(token:AutoLoginTokenReceive): Boolean {
        with(getPrefShared.edit()) {
            putString(TOKEN, token.token.toString()).apply()
            putString(LOGIN,token.login.toString()).apply()
        }
        return true
    }

    override fun getToken(): AutoLoginTokenReceive {
        val token =getPrefShared.getString(TOKEN, DEFAULT)
        val login = getPrefShared.getString(LOGIN, DEFAULT)
        return AutoLoginTokenReceive(token = token.toString(),login = login.toString())
    }

    override fun saveLoginAndInfo(tokenResponse: AutoLoginTokenResponse): Boolean {
        with(getPrefShared.edit()){
            putString(LOGIN,tokenResponse.login.toString()).apply()
            putString(FIRSTNAME,tokenResponse.firstname.toString()).apply()
            putString(LASTNAME,tokenResponse.lastname.toString()).apply()
        }
        return true
    }

    override fun getLoginAndInfo(): AutoLoginTokenResponse {
        val login = getPrefShared.getString(LOGIN, DEFAULT)
        val firstName = getPrefShared.getString(FIRSTNAME, DEFAULT)
        val lastName = getPrefShared.getString(LASTNAME, DEFAULT)
        return AutoLoginTokenResponse(login = login.toString(), firstname = firstName.toString(), lastname = lastName.toString())
    }


}