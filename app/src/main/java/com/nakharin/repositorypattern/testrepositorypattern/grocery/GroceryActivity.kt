package com.nakharin.repositorypattern.testrepositorypattern.grocery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.nakharin.repositorypattern.testrepositorypattern.R
import com.nakharin.repositorypattern.testrepositorypattern.data.GroceryItem
import com.nakharin.repositorypattern.testrepositorypattern.Injection
import kotlinx.android.synthetic.main.grocery_main.*

class GroceryActivity : AppCompatActivity(), GroceryContact.View {

    private lateinit var presenter: GroceryContact.UserActionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grocery_main)

        presenter = GroceryPresenter(this, Injection.provideRepository())
    }

    override fun onResume() {
        super.onResume()
        presenter.loadGrocecyItem(false)
    }

    override fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    override fun showGroceryItems(items: List<GroceryItem>) {
        val strBuilder = StringBuilder()
        for ((id) in items) {
            strBuilder.append(id).append("\n")
        }
        txtMessage.text = strBuilder.toString()
    }

    override fun showGroceryItem(item: GroceryItem) {
        txtMessage.text = item.id
    }
}
