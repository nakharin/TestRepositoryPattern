package com.nakharin.repositorypattern.testrepositorypattern.data

class RepositoryImpl constructor(var mService: ServiceApi): Repository {

    private var mCacheItems: ArrayList<GroceryItem> = arrayListOf()

    override fun getAllItems(callback: Repository.LoadItemsCallback) {
        if (mCacheItems.isEmpty()) {
            mService.getAllItems(object : ServiceApi.ServiceCallback<List<GroceryItem>> {
                override fun onLoaded(item: List<GroceryItem>) {
                    callback.onLoaded(item)
                }
            })
        } else {
            callback.onLoaded(mCacheItems)
        }
    }

    override fun getItem(id: String, callback: Repository.LoadItemCallback) {
        mService.getItem(id, object: ServiceApi.ServiceCallback<GroceryItem> {
            override fun onLoaded(item: GroceryItem) {
                callback.onLoaded(item)
            }
        })
    }

    override fun addItem(item: GroceryItem) {
        mService.addItem(item)
    }

    override fun clearCacheData() {
        mCacheItems.clear()
    }
}