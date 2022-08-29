package com.example.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.room.Card
import com.example.fooddelivery.R

class ProductAdapter(private val itemList: List<Card>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        val name = view.findViewById<TextView>(R.id.card_textview)
        val image = view.findViewById<ImageView>(R.id.card_image)
        val price = view.findViewById<TextView>(R.id.card_price)
        var count = view.findViewById<TextView>(R.id.card_count)
        val minusButton = view.findViewById<TextView>(R.id.minus_button_card)
        val textview = view.findViewById<TextView>(R.id.card_count)
        val plusButton = view.findViewById<TextView>(R.id.plus_button_card)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_card_view, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.textview.text = itemList[position].toString()

        holder.minusButton.setOnClickListener {
            if (holder.textview.text.toString().toInt() > 1)
                holder.textview.text = (holder.textview.text.toString().toInt() - 1).toString()
        }
        holder.plusButton.setOnClickListener {
            if (holder.textview.text.toString().toInt() < 8) {
                holder.textview.text = (holder.textview.text.toString().toInt() + 1).toString()
            }
        }

        holder.name.text = itemList[position].eatName
        holder.count.text = itemList[position].eatCount.toString()
        holder.price.text = itemList[position].price.toString()
        println("Get value: ${itemList[position].eatimage}")
        //holder.image.setImageResource(itemList[position].eatimage.toInt())
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}