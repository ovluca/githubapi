package com.example.githublogin.data;

import com.example.githublogin.data.model.ApiResponse;
import com.example.githublogin.data.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GitHubApi {

    @GET("/user/repos")
    Call<List<Repo>> getRepos(@Header("Authorization: Bearer") String token);

    @POST("/")
    Call<ApiResponse> login(String username, String password);
}
