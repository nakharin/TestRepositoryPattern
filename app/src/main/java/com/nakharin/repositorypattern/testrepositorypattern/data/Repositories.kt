package com.nakharin.repositorypattern.testrepositorypattern.data

class Repositories {
    companion object {

        private var repository: Repository? = null

        @Synchronized
        @JvmStatic
        fun getRepoInstance(serviceApi: ServiceApi): Repository {
            if (repository == null) {
                repository = RepositoryImpl(serviceApi)
            }

            return repository!!
        }
    }
}