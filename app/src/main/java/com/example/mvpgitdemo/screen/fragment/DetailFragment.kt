package com.example.mvpgitdemo.screen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mvpgitdemo.R
import kotlinx.android.synthetic.main.fragment_list.*

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        nameVirusTextView.text = arguments?.getString("NameVirus", "Nothing info")
        descVirusTextView.text = arguments?.getString("DescVirus","Nothing info")

        super.onViewCreated(view, savedInstanceState)
    }
}
