package com.lagradost.cloudstream3.syncproviders

interface InAppAuthAPI : AuthAPI {
    data class LoginData(
        val username: String?,
        val password: String?,
        val server: String?,
    )

    // this is for displaying the UI
    val requiresPassword: Boolean
    val requiresUsername: Boolean
    val requiresServer: Boolean

    // if this is false we can assume that getLatestLoginData returns null and wont be called
    // this is used in case for some reason it is not preferred to store any login data besides the "token" or encrypted data
    val storesPasswordInPlainText: Boolean

    // return true if logged in successfully
    suspend fun login(data: LoginData): Boolean

    // used to fill the UI if you want to edit any data about your login info
    fun getLatestLoginData(): LoginData?
}

abstract class InAppAuthAPIManager(defIndex: Int) : AccountManager(defIndex), InAppAuthAPI {
    override val requiresPassword = true
    override val requiresUsername = true
    override val requiresServer = false
    override val storesPasswordInPlainText = true

    override val idPrefix: String
        get() = throw NotImplementedError()

    override val name: String
        get() = throw NotImplementedError()

    override val icon: Int? = null

    override suspend fun login(data: InAppAuthAPI.LoginData): Boolean {
        throw NotImplementedError()
    }

    override fun getLatestLoginData(): InAppAuthAPI.LoginData? {
        throw NotImplementedError()
    }

    override fun loginInfo(): AuthAPI.LoginInfo? {
        throw NotImplementedError()
    }

    override fun logOut() {
        throw NotImplementedError()
    }
}