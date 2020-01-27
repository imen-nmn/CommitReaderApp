package com.example.commitreaderapp.ui.commit

import androidx.lifecycle.MutableLiveData
import com.example.commitreaderapp.BaseViewModel
import com.example.commitreaderapp.model.Commit
/**
 * View Model of Commit Item.
 */
class CommitViewModel: BaseViewModel() {
    private val commitAuthor = MutableLiveData<String>()
    private val commitMsg = MutableLiveData<String>()
    private val commitAvatarUrl = MutableLiveData<String>()
    private val commitSha = MutableLiveData<String>()

    fun bind(commit: Commit){
        commitAuthor.value = commit.commitDetail?.author?.name
        commitMsg.value = commit.commitDetail?.message
        commitAvatarUrl.value = commit.avatar?.avatarUrl
        commitSha.value = commit.commitDetail?.tree?.sha
    }

    fun getCommitAuthor():MutableLiveData<String>{
        return commitAuthor
    }

    fun getCommitMsg():MutableLiveData<String>{
        return commitMsg
    }

    fun getCommitAvatarUrl():MutableLiveData<String>{
        return commitAvatarUrl
    }

    fun getCommitSha():MutableLiveData<String>{
        return commitSha
    }
}