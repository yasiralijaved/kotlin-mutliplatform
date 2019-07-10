package com.yasiralijaved.kotlinmultiplatform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.yasiralijaved.kotlinmultiplatform.shared.ApplicationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()

        //create the ItemAdapter holding your Items
        val itemAdapter = ItemAdapter<UserItem>()
        //create the managing FastAdapter, by passing in the itemAdapter
        val fastAdapter = FastAdapter.with(itemAdapter)

        //set our adapters to the RecyclerView
        recyclerView.adapter = fastAdapter



        val api = ApplicationApi()

        api.users {
            GlobalScope.apply {
                launch (Dispatchers.Main) {
                    val userItems = it.map { UserItem(it) }

                    //set the items to your ItemAdapter
                    itemAdapter.clear()
                    itemAdapter.add(userItems)
                    // make copies of users list to increase the scrolling
                    itemAdapter.add(userItems)
                    itemAdapter.add(userItems)
                    itemAdapter.add(userItems)
                    itemAdapter.add(userItems)
                }
            }
        }
    }
}
