package com.nick.mowen.adtproject.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nick.mowen.adtproject.R
import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.databinding.ViewHolderCharacterBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity

class CharacterListAdapter(private val context: AbstractActivity, private val characterListPresenter: CharacterListPresenter) : ListAdapter<Character, RecyclerView.ViewHolder>(Character.DIFF_CALLBACK) {

    private val layoutInflater: LayoutInflater by lazy { LayoutInflater.from(context) }
    private val onClick: (Int) -> Unit = { position -> characterListPresenter.onCharacterClicked(getItem(position)) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CharacterViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.view_holder_character, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as CharacterViewHolder).bindData(getItem(position))

    private class CharacterViewHolder(private val binding: ViewHolderCharacterBinding, onClick: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { onClick(adapterPosition) }
        }

        fun bindData(data: Character) {
            binding.character = data
            binding.executePendingBindings()
        }
    }
}