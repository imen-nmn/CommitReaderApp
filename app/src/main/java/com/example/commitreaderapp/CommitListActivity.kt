package com.example.commitreaderapp

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.commitreaderapp.databinding.ActivityCommitListBinding
import com.example.commitreaderapp.ui.commit.CommitListViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * Activity that displays the commit list
 */
class CommitListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommitListBinding
    private lateinit var viewModel: CommitListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_commit_list)
        binding.commitList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this).get(CommitListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null)
                showError(errorMessage)
            else
                hideError()
        })
        binding.viewModel = viewModel
    }


    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}