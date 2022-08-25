package com.example.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.PopularModel
import com.example.fooddelivery.view.MainFragmentDirections

class PopularAdapter(val itemlist: ArrayList<PopularModel>) :
    RecyclerView.Adapter<PopularAdapter.myViewHolder>() {
    class myViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.eat_name)
        val image = view.findViewById(R.id.image) as ImageView
        val price = view.findViewById<TextView>(R.id.eat_price)
        var add = view.findViewById<TextView>(R.id.add_Btn)
        var containerImageWithText = view.findViewById<FrameLayout>(R.id.container_image_with_text)
        fun bindItem(populerFoodModel: PopularModel) {


            name.text = populerFoodModel.name
            image.setImageResource(populerFoodModel.image)
            price.text = populerFoodModel.price.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.populer_card_view, parent, false)
        return myViewHolder(view)
        //return myViewHolder(FragmentHomeBinding.inflate(R.layout.populer_card_view,parent,false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {


        holder.add.setOnClickListener {
            val data = itemlist[position]
            val action = MainFragmentDirections.actionMainFragmentToShowDetailFragment(data)
            Navigation.findNavController(it).navigate(action)
        }

        holder.bindItem(itemlist[position])
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

}