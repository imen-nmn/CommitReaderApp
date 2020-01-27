package com.example.commitreaderapp.model

import com.squareup.moshi.Json
/**
 * File provides all the required data model of the api.
 */
class Commit {
    @field:Json(name = "commit") var commitDetail: CommitDetail? = null
    @field:Json(name = "author") var avatar: Avatar?= null
}

class Avatar {
    var login: String? = null
    @field:Json(name = "avatar_url") var avatarUrl: String? = null
}

class CommitDetail {
    var author: Person? = null
    var message: String? = null
    var tree: Tree? = null
}

class Person {
    var name: String? = null
    var email: String? = null
    var date: String? = null
}


class Tree {
    var sha: String? = null
    var url: String? = null
}

