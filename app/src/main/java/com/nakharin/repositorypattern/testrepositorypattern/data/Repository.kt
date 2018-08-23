package com.nakharin.repositorypattern.testrepositorypattern.data

import android.support.annotation.NonNull

interface Repository {

    interface LoadItemsCallback {
        fun onLoaded(items: List<GroceryItem>)
    }

    interface LoadItemCallback {
        fun onLoaded(item: GroceryItem)
    }

    fun getAllItems(@NonNull callback: LoadItemsCallback)
    fun getItem(@NonNull id: String, @NonNull callback: LoadItemCallback)
    fun addItem(@NonNull item: GroceryItem)

    // in case you want to clear cache
    fun clearCacheData()
}