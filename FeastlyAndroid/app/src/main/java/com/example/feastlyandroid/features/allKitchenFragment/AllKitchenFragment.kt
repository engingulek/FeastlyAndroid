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
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.feastlyandroid.R
import com.example.feastlyandroid.databinding.FragmentAllKitchenBinding
import org.w3c.dom.Text


class AllKitchenFragment : Fragment(){
    private lateinit var desing:FragmentAllKitchenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        desing = DataBindingUtil.inflate(inflater,R.layout.fragment_all_kitchen, container, false)
        desing.allKitcthenRcv.layoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL)
        val adapter = AllKitchenAdapter(requireContext())
        desing.adapter = adapter



        return  desing.root
    }




}