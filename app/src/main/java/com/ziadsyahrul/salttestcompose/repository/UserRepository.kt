package com.ziadsyahrul.salttestcompose.repository


import com.ziadsyahrul.salttestcompose.network.ApiInterface
import com.ziadsyahrul.salttestcompose.utils.Resource
import com.ziadsyahrul.salttestcompose.model.LoginResponse
import com.ziadsyahrul.salttestcompose.model.UserResponse
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import kotlin.Exception

@ActivityScoped
class UserRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getUserResponse(): Resource<List<UserResponse>> {
        val response = try {
            apiInterface.getUserData().data
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }

    suspend fun loginUserResponse(email: String, password: String): Resource<LoginResponse> {
        val response = try {
            apiInterface.login(email, password)
        } catch (e: Exception) {
            return Resource.Error("Error dalam Login: ${e.localizedMessage}")
        }
        return Resource.Success(response)
    }
}