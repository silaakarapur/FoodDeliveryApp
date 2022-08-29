package com.example.fooddelivery.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.room.CardDatabase
import com.example.fooddelivery.adapter.ProductAdapter
import com.example.fooddelivery.databinding.FragmentCardBinding


class CardFragment : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    lateinit var binding: FragmentCardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val cardDatabase: CardDatabase = CardDatabase.getCardDatabase(requireContext())!!

            //val itemSizeValue = CardFragmentArgs.fromBundle(it).itemSize
         //   println("Get item size value: $itemSizeValue")
            val allArray = cardDatabase.getCardDao().getAllBook()
            productAdapter = ProductAdapter(allArray)
            val lmVertical = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.adapter = productAdapter
            binding.recyclerView.layoutManager = lmVertical
        }
    }

}