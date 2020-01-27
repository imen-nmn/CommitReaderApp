package com.example.commitreaderapp.network

import com.example.commitreaderapp.model.Commit
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CommitApi {
    /**
     * Get the list of the commits from the API
     */

    @GET("/repos/torvalds/linux/commits")
    fun getCommits(): Observable<List<Commit>>
}