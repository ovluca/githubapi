package com.example.githublogin.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githublogin.data.model.ApiResponse;
import com.example.githublogin.data.repository.GitHubRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<ApiResponse> loginMutableLiveData;
    private GitHubRepository gitHubRepository;

    public LoginViewModel() {
        init();
    }

    public void init() {
        if (loginMutableLiveData != null) {
            return;
        }
        gitHubRepository = GitHubRepository.getInstance();
    }

    public void login(String username, String password) {
        loginMutableLiveData = gitHubRepository.login(username, password);
    }

    public LiveData<ApiResponse> loginLiveData() {
        return loginMutableLiveData;
    }

}