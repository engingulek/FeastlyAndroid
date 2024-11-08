package com.example.feastlyandroid.features.homeFeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private  lateinit var design:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        //TODO: These wil be come from viewModel
        design.toolbarTitle = getString(R.string.homePageTitle)
        design.kitchensTitle = getString(R.string.kitchensTitle)
        design.allKitchensTitle = getString( R.string.allKitchensTitle)
        val adapter = KitchensAdapter(requireContext())
        design.kitchensAdapter = adapter
        design.kitchensRycV.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        return  design.root

    }


}