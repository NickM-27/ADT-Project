package com.nick.mowen.adtproject.characterlist

import android.content.res.Configuration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.databinding.FragmentCharacterListBinding
import com.nick.mowen.adtproject.location.CharacterLocationDialog
import com.nick.mowen.adtproject.skeleton.AbstractActivity
import com.nick.mowen.adtproject.skeleton.AbstractPresenter

class CharacterListPresenter(
    private val context: AbstractActivity,
    private val binding: FragmentCharacterListBinding,
    private val viewModel: CharacterListViewModel
) : AbstractPresenter(context) {

    fun getLayoutManager(): RecyclerView.LayoutManager =
        when (context.resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> LinearLayoutManager(context)
            Configuration.ORIENTATION_LANDSCAPE -> GridLayoutManager(context, 2)
            else -> LinearLayoutManager(context)
        }

    fun onCharacterClicked(character: Character) {
        CharacterLocationDialog(character).show(context.supportFragmentManager, CharacterLocationDialog.FRAGMENT_TAG)
    }
}