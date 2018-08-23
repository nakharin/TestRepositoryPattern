package com.nakharin.repositorypattern.testrepositorypattern.data

data class GroceryItem(var id: String, var name:String, var price: Int) {

    override fun toString(): String {
        return "${this.id} : ${this.name} = ${this.price}"
    }
}