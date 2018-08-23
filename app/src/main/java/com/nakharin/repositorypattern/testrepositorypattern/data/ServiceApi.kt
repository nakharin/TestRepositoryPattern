package com.nakharin.repositorypattern.testrepositorypattern.data

interface ServiceApi {

    interface ServiceCallback<T> {
        fun onLoaded(item: T)
    }

    fun getAllItems(callback: ServiceCallback<List<GroceryItem>>)
    fun getItem(id: String, callback: ServiceCallback<GroceryItem>)
    fun addItem(item: GroceryItem)
}