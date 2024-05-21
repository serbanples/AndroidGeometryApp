package com.example.pmdfinal.api.services;

import com.example.pmdfinal.api.models.LoginUserModel;
import com.example.pmdfinal.api.models.RegisterUserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/auth/register")
    Call<Void> registerUser(@Body RegisterUserModel user);

    @POST("/api/auth/login")
    Call<Void> loginUser(@Body LoginUserModel user);

}
