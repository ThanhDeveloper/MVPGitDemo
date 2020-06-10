package com.example.mvpgitdemo.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvpgitdemo.R
import com.example.mvpgitdemo.utils.Constant
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

        nameVirusTextView.text = arguments?.getString(Constant.KEY_NAME, Constant.KEY_NON_INFO)
        descVirusTextView.text = arguments?.getString(Constant.KEY_DESC, Constant.KEY_NON_INFO)

        super.onViewCreated(view, savedInstanceState)
    }
}
