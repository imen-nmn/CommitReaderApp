package com.example.commitreaderapp.injection

import com.example.commitreaderapp.ui.commit.CommitListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified CommitListViewModel.
     * @param commitListViewModel CommitListViewModel in which to inject the dependencies
     */
    fun inject(commitListViewModel: CommitListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}