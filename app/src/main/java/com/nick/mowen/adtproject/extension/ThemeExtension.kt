package com.nick.mowen.adtproject.extension

import android.content.Context
import androidx.databinding.ViewDataBinding
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.databinding.FragmentCharacterListBinding

fun ViewDataBinding.themeBinding(context: Context) {

    when (this) {
        is ActivityMainBinding -> {

        }
        is FragmentCharacterListBinding -> {

        }
    }
}