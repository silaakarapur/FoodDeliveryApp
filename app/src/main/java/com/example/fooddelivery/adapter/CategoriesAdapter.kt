package com.example.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.CategoriesModel

class CategoriesAdapter(val itemlist: ArrayList<CategoriesModel>) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(categoriesModel: CategoriesModel){


            val description = view.findViewById(R.id.add_Btn) as TextView
            val image = view.findViewById(R.id.image) as ImageView

            description.text= categoriesModel.description
            image.setImageResource(categoriesModel.image)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_card_view, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(itemlist[position])
    }

}