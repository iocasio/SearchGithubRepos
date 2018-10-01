package com.example.iocasio.searchgithubrepos

import com.example.iocasio.searchgithubrepos.model.Repository
import org.junit.Test
import kotlin.collections.ArrayList

class GithubRepoSortingUnitText {

    /*
    * Basic test to see if the sorting is working properly.
     */

    private val repositoryArray = arrayOf(
            Repository("TestName", "url", null, "description", 5),
            Repository("TestName", "url", null, "description", 3),
            Repository("TestName", "url", null, "description", 8),
            Repository("TestName", "url", null, "description", 0),//Min value
            Repository("TestName", "url", null, "description", 1),
            Repository("TestName", "url", null, "description", 10),
            Repository("TestName", "url", null, "description", 12),//Max value
            Repository("TestName", "url", null, "description", 6),
            Repository("TestName", "url", null, "description", 4),
            Repository("TestName", "url", null, "description", 2),
            Repository("TestName", "url", null, "description", 7),
            Repository("TestName", "url", null, "description", 11),
            Repository("TestName", "url", null, "description", 9),
            Repository("TestName", "url", null, "description", 4))

    @Test
    fun testSortingRepos() {
        var repoList = repositoryArray.toCollection(ArrayList())
        repoList = Repository.orderDescendingRepositoryList(repoList)
        for (i in 0 until repoList.size - 1) {
            val isGreater = repoList[i].starCount > repoList[i + 1].starCount
            val isEqual = repoList[i].starCount == repoList[i+1].starCount
            assert(isGreater || isEqual)
        }
    }
}