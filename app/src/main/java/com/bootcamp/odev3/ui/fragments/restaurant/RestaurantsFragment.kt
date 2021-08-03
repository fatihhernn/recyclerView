package com.bootcamp.odev3.ui.fragments.restaurant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.odev3.R
import com.bootcamp.odev3.databinding.FragmentRestaurantsBinding
import com.bootcamp.odev3.models.listing.RestaurantsBaseResponse
import com.bootcamp.odev3.utils.RetrofitHelper
import com.bootcamp.odev3.utils.RetrofitResponseHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job


class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    private var retrofitHelper: RetrofitHelper? = null
    private var adapter = RestaurantAdapter()
    private var page = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("RestaurantFragment", "onViewCreated")
        retrofitHelper = RetrofitHelper()

        initViews(view)
        fetchData(page)

    }

    private fun fetchData(page: Int) {
        Log.v("ListFragment", "fetchData")

        Toast.makeText(context, "Page Number: $page", Toast.LENGTH_SHORT).show()
        retrofitHelper?.listCharacter(page = page, object : RetrofitResponseHandler {
            override fun onError() {
                Log.v("MainActivity", "Error :(")

            }

            override fun onResponse(response: RestaurantsBaseResponse) {
                Log.v("ListFragment", "onResponse")
                adapter.setRestaurantData(response.data.data)
            }
        })
    }

    private fun initViews(view: View) {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}