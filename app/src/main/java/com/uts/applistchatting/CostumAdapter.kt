package com.uts.applistchatting

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

internal class CustomAdapter(private val context: Context, private val dataList: List<Product>) :
    ArrayAdapter<Product>(context, R.layout.item_list_view, dataList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false)

        val product = dataList[position]

        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemDescription: TextView = view.findViewById(R.id.item_description)
        val itemPrice: TextView = view.findViewById(R.id.item_price)
        val itemBuyButton: Button = view.findViewById(R.id.item_buy_button)

        // Set data into views
        itemImage.setImageResource(product.imageResId)
        itemTitle.text = product.title
        itemDescription.text = product.description
        itemPrice.text = "$${product.price}"

        // Set click listener for "Buy Now" button
        itemBuyButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(product.buyLink))
            context.startActivity(intent)
        }

        return view
    }
}
