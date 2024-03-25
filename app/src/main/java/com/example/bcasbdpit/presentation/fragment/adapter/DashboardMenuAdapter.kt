package com.example.bcasbdpit.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bcasbdpit.R
import com.example.bcasbdpit.model.MenuDashboard
import com.example.bcasbdpit.model.MenuDashboardModel
import java.security.PrivateKey


class DashboardMenuAdapter(
    private val menuData : List<MenuDashboard>,
    private val context: Context
) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private  var image: ImageView? = null
    private var textMenu: TextView? = null

    override fun getCount(): Int {
        return menuData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var bindingView = convertView
        if (layoutInflater == null){
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        }

        if (bindingView == null) {
            bindingView = layoutInflater?.inflate(R.layout.item_menu_dashboard, null)
        }

        image = bindingView?.findViewById(R.id.ivIkonMenu)
        textMenu = bindingView?.findViewById(R.id.tvMenu)

        // get data from list according position
        val result = menuData[position]
//        image?.setImageResource(result.image)
        textMenu?.text = result.nameMenu

        return bindingView
    }


}