package com.example.githublogin.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.githublogin.data.GitHubApi;
import com.example.githublogin.data.api.RetrofitService;
import com.example.githublogin.data.model.ApiResponse;
import com.example.githublogin.data.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubRepository {
    private static GitHubRepository repository;
    private GitHubApi gitHubApi;

    public GitHubRepository() {
        gitHubApi = RetrofitService.createService(GitHubApi.class);
    }

    public static GitHubRepository getInstance() {
        if (repository == null) {
            repository = new GitHubRepository();
        }
        return repository;
    }

    public MutableLiveData<ApiResponse> login(String username, String password) {
        MutableLiveData<ApiResponse> loginData = new MutableLiveData<>();
        gitHubApi.login(username, password).enqueue(new Callback<ApiResponse>() {


            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    loginData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                loginData.setValue(null);
            }
        });

        return loginData;
    }

    public MutableLiveData<List<Repo>> getRepos() {
        MutableLiveData<List<Repo>> reposData = new MutableLiveData<>();
        gitHubApi.getRepos("d4203d6ac26ecf26cdf6a9b0f6ea43237e6b6ce3").enqueue(new Callback<List<Repo>>() {


            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    reposData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                reposData.setValue(null);
            }
        });

        return reposData;
    }
}
