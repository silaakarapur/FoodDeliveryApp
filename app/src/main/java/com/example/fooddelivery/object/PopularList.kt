package com.example.fooddelivery.`object`

import com.example.fooddelivery.R
import com.example.fooddelivery.model.PopularModel

object PopularList {

    fun getFavoritesItemList(): ArrayList<PopularModel> {
        val itemModel1 = PopularModel(
            "Pizza",
            R.drawable.button,
            4.11,
            "Description",
        )
        val itemModel2 = PopularModel(
            "Hamburger",
            R.drawable.button,
            4.11,
            "Description",
        )
        val itemModel3 = PopularModel(
            "Pizza",
            R.drawable.button,
            4.11,
            "Description",

            )

        val itemModel4 = PopularModel(
            "Pizza",
            R.drawable.button,
            4.11,
            "Description",

            )


        val itemList: ArrayList<PopularModel> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)

        return itemList
    }
}