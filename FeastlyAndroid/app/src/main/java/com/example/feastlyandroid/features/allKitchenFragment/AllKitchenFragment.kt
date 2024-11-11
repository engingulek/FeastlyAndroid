package com.example.feastlyandroid.features.allKitchenFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.FragmentAllKitchenBinding
import com.example.feastlyandroid.utils.toFragment
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class AllKitchenFragment : Fragment(){
    private lateinit var desing:FragmentAllKitchenBinding
    private lateinit var viewModel:AllKitchenViewModelInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        desing = DataBindingUtil.inflate(inflater,R.layout.fragment_all_kitchen, container, false)
        desing.allKitcthenRcv.layoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL)

        viewModel.kitchenList.observe(viewLifecycleOwner){
            val adapter = AllKitchenAdapter(requireContext(),viewModel,it)
            desing.adapter = adapter
        }

        viewModel.selectedAllKitchenLiveData.observe(viewLifecycleOwner){
            desing.listState = it.isNotEmpty()
        }


        desing.closeButton.setOnClickListener {
            findNavController().navigateUp()
        }

        desing.listButton.setOnClickListener {
            val list = viewModel.getSelectedList()
            val nav = AllKitchenFragmentDirections.toFilterFromAllKitchens(list.toTypedArray())
            Navigation.toFragment(it,nav)
        }


        return  desing.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AllKitchenViewModelInterface by viewModels<AllKitchenViewModel>()
        viewModel = tempViewModel
    }

}