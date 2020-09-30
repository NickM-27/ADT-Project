package com.nick.mowen.adtproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.nick.mowen.adtproject.characterlist.CharacterListFragment
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.extension.themeBinding
import com.nick.mowen.adtproject.extension.toggleTheme
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
        binding.themeBinding(this)
        supportFragmentManager.beginTransaction().replace(binding.content.id, characterListFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_toggle_theme -> {
                toggleTheme()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}