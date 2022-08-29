package com.example.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.PopularModel
import com.example.fooddelivery.view.MainFragmentDirections

class PopularAdapter(val itemList: ArrayList<PopularModel>):
    RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {
    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        val name  = view.findViewById<TextView>(R.id.eat_name)
        val image = view.findViewById<ImageView>(R.id.image)
        val price = view.findViewById<TextView>(R.id.eat_price)
        var add   = view.findViewById<TextView>(R.id.add_Btn)

        fun bindItem(popularFoodModel: PopularModel) {
            name.text = popularFoodModel.name
            image.setImageResource(popularFoodModel.image)
            price.text = popularFoodModel.price.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.populer_card_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.add.setOnClickListener {
            val data = itemList[position]
            val action = MainFragmentDirections.actionMainFragmentToShowDetailFragment(data)
            Navigation.findNavController(it).navigate(action)
        }

        holder.bindItem(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}