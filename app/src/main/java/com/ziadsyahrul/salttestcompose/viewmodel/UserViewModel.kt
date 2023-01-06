package com.ziadsyahrul.salttestcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ziadsyahrul.salttestcompose.model.LoginResponse
import com.ziadsyahrul.salttestcompose.model.UserResponse

import com.ziadsyahrul.salttestcompose.repository.UserRepository
import com.ziadsyahrul.salttestcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRespository: UserRepository
) : ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<List<UserResponse>> =
        MutableLiveData<List<UserResponse>>()
    var getUserData: LiveData<List<UserResponse>> = _getUserData

    private var _getUserLogin: MutableLiveData<LoginResponse> =
        MutableLiveData<LoginResponse>()
    var getUserLogin: LiveData<LoginResponse> = _getUserLogin

    suspend fun getUserData(): Resource<List<UserResponse>> {
        val result = userRespository.getUserResponse()
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }

        return result
    }

    suspend fun loginUser(email: String, password: String): Resource<LoginResponse> {
        val result = userRespository.loginUserResponse(email, password)
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserLogin.value = result.data!!
        }
        return result
    }
}