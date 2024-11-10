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
import com.example.feastlyandroid.utils.toFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  lateinit var design:FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        //TODO: These wil be come from viewModel
        design.toolbarTitle = getString(R.string.homePageTitle)
        design.kitchensTitle = getString(R.string.kitchensTitle)
        design.allKitchensTitle = getString( R.string.allKitchensTitle)
        design.restaurants = getString(R.string.restaurants)


        design.kitchensRycV.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        design.restaurnatRycv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel.kitchenList.observe(viewLifecycleOwner){

            val adapter = KitchensAdapter(requireContext(),it,viewModel)
            design.kitchensAdapter = adapter
            Log.e("Last","${it.size}")


        }
        design.allKitchensTxt.setOnClickListener {
            Navigation.toFragment(it,R.id.toAllKitchenFragment)
        }

        viewModel.listDesignType.observe(viewLifecycleOwner){
            design.listType = it
        }

        viewModel.listDesignType.observe(viewLifecycleOwner){
            if (it){
                val restaurantAdapter = RestaurantListTypeOneAdapter(requireContext(),viewModel)
                design.restaurantListTypeOneAdapter = restaurantAdapter
            }else{
                val restaurantAdapter = RestaurantListTypeTwoAdapter(requireContext(),viewModel)
                design.restaurantListTypeTwoAdapter = restaurantAdapter
            }
        }


        design.viewListId.setOnClickListener{
            viewModel.onClickListDesign()
            Log.e("Test","view list type")
        }
        return  design.root

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }


}