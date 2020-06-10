package com.example.mvpgitdemo.utils

interface BasePresenter<T> {
    fun onStart()
    fun setView(view: T?)
}