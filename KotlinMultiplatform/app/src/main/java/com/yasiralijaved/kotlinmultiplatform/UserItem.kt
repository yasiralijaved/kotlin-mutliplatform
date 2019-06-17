package com.yasiralijaved.kotlinmultiplatform

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.yasiralijaved.kotlinmultiplatform.shared.models.User

open class UserItem(user: User) : AbstractItem<UserItem.ViewHolder>() {


    var userObj: User? = user

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.tv_user_name

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.row_user_list

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }



    class ViewHolder(view: View) : FastAdapter.ViewHolder<UserItem>(view) {
        var name: TextView = view.findViewById(R.id.tv_user_name)

        override fun bindView(item: UserItem, payloads: MutableList<Any>) {
            name.text = item.userObj?.name
        }

        override fun unbindView(item: UserItem) {
            name.text = null
        }
    }
}