package com.nick.mowen.adtproject.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nick.mowen.adtproject.R
import com.nick.mowen.adtproject.databinding.FragmentCharacterListBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity
import com.nick.mowen.adtproject.skeleton.AbstractFragment

class CharacterListFragment : AbstractFragment() {

    override lateinit var binding: FragmentCharacterListBinding
    private val viewModel: CharacterListViewModel by lazy { ViewModelProvider(this).get(CharacterListViewModel::class.java) }
    private val presenter: CharacterListPresenter by lazy { CharacterListPresenter(requireActivity() as AbstractActivity, binding, viewModel) }

    override fun inflateViews(layoutInflater: LayoutInflater, parent: ViewGroup?) {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_character_list, parent, false)
    }

    override fun bindViews() {
        binding.characters.apply {
            layoutManager = presenter.getLayoutManager()
            adapter = CharacterListAdapter(requireActivity() as AbstractActivity, presenter).also { adapter ->
                viewModel.getCharacters().observe(viewLifecycleOwner, { adapter.submitList(it) })
            }
        }
    }
}