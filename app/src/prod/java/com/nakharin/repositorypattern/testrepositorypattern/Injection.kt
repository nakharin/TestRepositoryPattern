package com.nakharin.repositorypattern.testrepositorypattern

import com.nakharin.repositorypattern.testrepositorypattern.data.Repositories
import com.nakharin.repositorypattern.testrepositorypattern.data.Repository
import com.nakharin.repositorypattern.testrepositorypattern.data.ServiceApiImpl

class Injection {

    companion object {
        @JvmStatic
        fun provideRepository(): Repository {
            return Repositories.getRepoInstance(ServiceApiImpl())
        }
    }
}
