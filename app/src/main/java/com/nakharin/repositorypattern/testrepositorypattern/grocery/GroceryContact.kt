package com.nakharin.repositorypattern.testrepositorypattern.grocery

import com.nakharin.repositorypattern.testrepositorypattern.data.GroceryItem

class GroceryContact {

    interface View {
        fun showToast(str: String)
        fun showGroceryItems(items: List<GroceryItem>)
        fun showGroceryItem(item: GroceryItem)
    }

    interface UserActionListener {
        fun loadGroceryItem(forceUpdate: Boolean)
        fun randomItem()
        fun autoAddItem()
    }
}