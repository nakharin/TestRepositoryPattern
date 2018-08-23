package com.nakharin.repositorypattern.testrepositorypattern.data

import java.util.*

class MockServiceApiImpl : ServiceApi {

    private val mMockData = HashMap<String, GroceryItem>()

    init {
        initMockData()
    }

    private fun initMockData() {
        //you can initial mock data here.
        //you might assign them from json or any data source that you want.
        mMockData.put("id-1", GroceryItem("id-1", "MockItem1", 10))
        mMockData.put("id-2", GroceryItem("id-2", "MockItem2", 20))
        mMockData.put("id-3", GroceryItem("id-3", "MockItem3", 30))
        mMockData.put("id-4", GroceryItem("id-4", "MockItem4", 40))
        mMockData.put("id-5", GroceryItem("id-5", "MockItem5", 50))
    }

    override fun getAllItems(callback: ServiceApi.ServiceCallback<List<GroceryItem>>) {
        callback.onLoaded(ArrayList(mMockData.values))
    }

    override fun getItem(id: String, callback: ServiceApi.ServiceCallback<GroceryItem>) {
        callback.onLoaded(mMockData[id]!!)
    }

    override fun addItem(item: GroceryItem) {
        mMockData.put(item.id, item)
    }
}