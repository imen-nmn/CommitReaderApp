package com.example.commitreaderapp

import androidx.lifecycle.ViewModel
import com.example.commitreaderapp.injection.DaggerViewModelInjector
import com.example.commitreaderapp.injection.NetworkModule
import com.example.commitreaderapp.injection.ViewModelInjector
import com.example.commitreaderapp.ui.commit.CommitListViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CommitListViewModel -> injector.inject(this)
        }
    }
}