package com.example.fooddelivery.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.`object`.MockList
import com.example.fooddelivery.adapter.CategoriesAdapter
import com.example.fooddelivery.databinding.FragmentMainBinding


class MainFragment : Fragment() {
lateinit var _binding:FragmentMainBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = _binding.root
        initRecyclerView()
        return view
    }
    fun initRecyclerView() {



        categoriesAdapter = CategoriesAdapter(MockList.getMockedItemList())
        val lmHorizontal = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val lmHorizontal2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        _binding?.apply {
            recy.adapter = categoriesAdapter
            recy.layoutManager = lmHorizontal
//           recy2.adapter = popularAdapter
//            recy2.layoutManager = lmHorizontal2

//            profileBtn.setOnClickListener {
//                if (mAuth.currentUser != null) {
//                    val action = HomeFragmentDirections.actionHomeFragmentToCustomerFragment()
//                    Navigation.findNavController(it).navigate(action)
//
//                } else {
//                    val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
//                    Navigation.findNavController(it).navigate(action)
//                }
//
//            }
        }
    }

}