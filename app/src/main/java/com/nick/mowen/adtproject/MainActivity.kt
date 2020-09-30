package com.nick.mowen.adtproject

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nick.mowen.adtproject.R
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity

class MainActivity : AbstractActivity() {

    override lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
    }

    override fun bindViews() {
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.content
    }
}