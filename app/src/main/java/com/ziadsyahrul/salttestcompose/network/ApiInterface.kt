package com.ziadsyahrul.salttestcompose.network


import com.ziadsyahrul.salttestcompose.model.LoginResponse
import com.ziadsyahrul.salttestcompose.model.UserData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("users")
    suspend fun getUserData(): UserData

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse
}