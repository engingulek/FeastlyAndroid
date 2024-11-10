package com.example.feastlyandroid.features.filterListFeature

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.FragmentFilterRestaurnatListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterRestaurnatListFragment : Fragment() {
    private lateinit var design: FragmentFilterRestaurnatListBinding
    private lateinit var viewModel: FilterRestaurantViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle:FilterRestaurnatListFragmentArgs by navArgs()
        val list = bundle.selectedKitchen
        Log.e("listt","${list[0]}")
        viewModel.getData(list.toList())
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_filter_restaurnat_list,container,false)
      viewModel.filterRestaurantList.observe(viewLifecycleOwner){
          val adapter = FilterRestaurantAdapter(requireContext(), it)
          design.adapter = adapter
          design.filterTitleTxt.text = "Filtered Restaurants(${it.count()})"
      }

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : FilterRestaurantViewModel by viewModels()
        viewModel = tempViewModel
    }


}