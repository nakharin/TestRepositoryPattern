package com.nakharin.repositorypattern.testrepositorypattern.grocery

import com.nakharin.repositorypattern.testrepositorypattern.data.GroceryItem
import com.nakharin.repositorypattern.testrepositorypattern.data.Repository
import java.util.*

class GroceryPresenter constructor(var view: GroceryContact.View, var repository: Repository): GroceryContact.UserActionListener {

    override fun loadGroceryItem(forceUpdate: Boolean) {
        if (forceUpdate) {
            repository.clearCacheData()
        }

        repository.getAllItems(object : Repository.LoadItemsCallback {
            override fun onLoaded(items: List<GroceryItem>) {
                view.showGroceryItems(items)
            }
        })
    }

    override fun randomItem() {
        repository.getAllItems(object : Repository.LoadItemsCallback {
            override fun onLoaded(items: List<GroceryItem>) {
                if (items.isNotEmpty()) {
                    view.showGroceryItem(items[Random().nextInt(items.size)])
                } else {
                    view.showToast("No grocery item")
                }
            }
        })
    }

    override fun autoAddItem() {
        val id = UUID.randomUUID().toString()
        val item = GroceryItem(id, "auto add item", 0)
        repository.addItem(item)
        view.showToast("Added!")
    }
}