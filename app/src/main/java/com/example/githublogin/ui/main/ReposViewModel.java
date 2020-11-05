package com.example.githublogin.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githublogin.data.model.Repo;
import com.example.githublogin.data.repository.GitHubRepository;

import java.util.List;

public class ReposViewModel extends ViewModel {
    private MutableLiveData<List<Repo>> loginMutableLiveData;
    private GitHubRepository gitHubRepository;

    public ReposViewModel() {
        init();
    }

    public void init() {
        if (loginMutableLiveData != null) {
            return;
        }
        gitHubRepository = GitHubRepository.getInstance();
    }

    public void getRepos() {
        loginMutableLiveData = gitHubRepository.getRepos();
    }

    public LiveData<List<Repo>> loginLiveData() {
        return loginMutableLiveData;
    }

}