package com.example.feastlyandroid.features.homeFeature

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.FragmentHomeBinding
import com.example.feastlyandroid.features.homeFeature.adapters.KitchensAdapter
import com.example.feastlyandroid.features.homeFeature.adapters.RestaurantListTypeOneAdapter
import com.example.feastlyandroid.features.homeFeature.adapters.RestaurantListTypeTwoAdapter
import com.example.feastlyandroid.utils.toFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  lateinit var design:FragmentHomeBinding
    private lateinit var viewModel: HomeViewModelInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        design.toolbarTitle = getString(viewModel.toolbarTitle)
        design.kitchensTitle = getString(viewModel.kitchensTitle)
        design.allKitchensTitle = getString(viewModel.allKitchensTitle)
        design.restaurants = getString(viewModel.restaurants)


        design.kitchensRycV.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        design.restaurnatRycv.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        viewModel.kitchenList.observe(viewLifecycleOwner){

            val adapter = KitchensAdapter(requireContext(),it)
            design.kitchensAdapter = adapter

        }
        design.allKitchensTxt.setOnClickListener {
            Navigation.toFragment(it,R.id.toAllKitchenFragment)
        }

        viewModel.listDesignType.observe(viewLifecycleOwner){
            design.listType = it
        }

        viewModel.listDesignType.observe(viewLifecycleOwner){ type ->
            viewModel.restaurantList.observe(viewLifecycleOwner){ list ->
                if (type){
                    val restaurantAdapter = RestaurantListTypeOneAdapter(requireContext(),
                        list,viewModel)
                    design.restaurantListTypeOneAdapter = restaurantAdapter
                }else{
                    val restaurantAdapter = RestaurantListTypeTwoAdapter(requireContext(),
                        list,viewModel)
                    design.restaurantListTypeTwoAdapter = restaurantAdapter
                }
            }
        }
        
        design.viewListId.setOnClickListener{
            viewModel.onClickListDesign()

        }
        return  design.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModelInterface by viewModels<HomeViewModel>()
        viewModel = tempViewModel
    }
}