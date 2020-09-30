package com.nick.mowen.adtproject

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nick.mowen.adtproject.characterlist.CharacterListFragment
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity

class MainActivity : AbstractActivity() {

    override lateinit var binding: ActivityMainBinding
    private val characterListFragment: CharacterListFragment by lazy { CharacterListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
    }

    override fun bindViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(binding.content.id, characterListFragment).commit()
    }
}