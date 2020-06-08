package com.example.mvpgitdemo.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.mvpgitdemo.R
import com.example.mvpgitdemo.data.CoronaVirusRepository
import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.screen.fragment.DetailFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainContract.View {

    private lateinit var objectName: String
    private lateinit var objectDesc: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        button.setOnClickListener() {
            openFragment(objectName, objectDesc)
        }
    }

    override fun onGetInfoSuccess(info: MutableList<CoronaVirus>) {
        updateData(info)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        val presenter =
            MainPresenter(CoronaVirusRepository.instance)
        presenter.setView(this)
        presenter.onStart()
    }

    fun updateData(infoVirus: MutableList<CoronaVirus>?) {
        infoVirus?.let{
            for(element in infoVirus)
            {
                objectName = element.name.toString()
                objectDesc = element.description.toString()
            }
        }
    }

    fun openFragment(name: String, desc: String) {
        val transaction = supportFragmentManager.beginTransaction()
        val detailFragment = DetailFragment().apply {
            arguments = bundleOf(
                "NameVirus" to name,
                "DescVirus" to desc
            )
        }
        transaction.let {
            it.add(R.id.frameContent,detailFragment)
            it.addToBackStack(null)
            it.commit()
        }
    }
}
