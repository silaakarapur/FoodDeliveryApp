package com.example.fooddelivery.`object`

import com.example.fooddelivery.R
import com.example.fooddelivery.model.CategoriesModel

object MockList {

    fun getMockedItemList(): ArrayList<CategoriesModel> {
        val itemModel1 = CategoriesModel(
            R.drawable.image_banner,
            "PİZZA",
        )
        val itemModel2 = CategoriesModel(
            R.drawable.image_banner,
            "BURGER",
        )
        val itemModel3 = CategoriesModel(
            R.drawable.image_banner,
            "HOTDOG",
        )

        val itemModel4 = CategoriesModel(
            R.drawable.image_banner,
            "DRINK",
        )


        val itemList: ArrayList<CategoriesModel> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)

        return itemList
    }

}
