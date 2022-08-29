package com.example.fooddelivery.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.fooddelivery.room.Card
import com.example.fooddelivery.room.CardDatabase
import com.example.fooddelivery.databinding.FragmentShowDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShowDetailFragment : Fragment() {
    lateinit var binding: FragmentShowDetailBinding
    val popularEat by navArgs<ShowDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDetailBinding.inflate(layoutInflater)

        binding.apply {
            plusButton.setOnClickListener {


                if (textView13.text.toString().toInt() < 8) {
                    textView13.text = (binding.textView13.text.toString().toInt() + 1).toString()
                }

            }
            minusButton.setOnClickListener {
                if (textView13.text.toString().toInt() > 1) {
                    textView13.text =
                        (textView13.text.toString().toInt() - 1).toString()
                }


            }
            addToCardButton.setOnClickListener {
                val action =
                    ShowDetailFragmentDirections.actionShowDetailFragmentToCardFragment()
                Navigation.findNavController(it).navigate(action)
                add()
                read()
            }
            title.text = popularEat.data.name
            price.text = popularEat.data.price.toString()
            popularEat.data.image.let { eatImage.setImageResource(it) }
            description.text=popularEat.data.description
        }
        return binding.root
    }

    private fun add() {
        val cardDatabase: CardDatabase? = CardDatabase.getCardDatabase(requireContext())

        binding.apply {

            val title = title.text.toString()
            val textView = textView13.text.toString().toInt()
            val price = price.text.toString().toDouble()
            val image = eatImage.toString()

            cardDatabase?.getCardDao()?.addData(
                Card(title, textView, price, image)
            )
        }
    }

    private fun read() {
        CoroutineScope(Dispatchers.Default).launch {
            val cardDatabase: CardDatabase = CardDatabase.getCardDatabase(requireContext())!!
            val allMembers = cardDatabase.getCardDao().getAllBook()
            for (i in allMembers) {
                Log.i("Log", i.eatId.toString())
                Log.i("Log", i.eatName)
                Log.i("Log", i.price.toString())
                Log.i("Log", i.eatCount.toString())

            }
        }
    }
}