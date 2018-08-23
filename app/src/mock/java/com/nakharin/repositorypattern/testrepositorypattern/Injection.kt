package com.nakharin.repositorypattern.testrepositorypattern

import com.nakharin.repositorypattern.testrepositorypattern.data.MockServiceApiImpl
import com.nakharin.repositorypattern.testrepositorypattern.data.Repositories
import com.nakharin.repositorypattern.testrepositorypattern.data.Repository

class Injection {

    companion object {

        @JvmStatic
        fun provideRepository(): Repository {
            return Repositories.getRepoInstance(MockServiceApiImpl())
        }
    }
}
