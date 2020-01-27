package com.example.commitreaderapp.ui.commit

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.commitreaderapp.BaseViewModel
import com.example.commitreaderapp.R
import com.example.commitreaderapp.model.Commit
import com.example.commitreaderapp.network.CommitApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**
 * View Model of Commit List.
 */
class CommitListViewModel : BaseViewModel() {
    @Inject
    lateinit var commitApi: CommitApi

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadCommits() }

    val commitListAdapter: CommitListAdapter = CommitListAdapter()

    private lateinit var subscription: Disposable

    init {
        loadCommits()
    }

    private fun loadCommits() {
        subscription = commitApi.getCommits()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveCommitListStart() }
            .doOnTerminate { onRetrieveCommitListFinish() }
            .subscribe(
                // Add result
                { result -> onRetrieveCommitListSuccess(result) },
                {
                    Log.e("commitTag", " $it")
                    onRetrieveCommitListError() }
            )
    }

    private fun onRetrieveCommitListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveCommitListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCommitListSuccess(commitList: List<Commit>) {
        commitListAdapter.updateCommitList(commitList)
    }

    private fun onRetrieveCommitListError() {
        errorMessage.value = R.string.commit_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}