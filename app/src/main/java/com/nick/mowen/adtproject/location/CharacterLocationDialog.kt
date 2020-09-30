package com.nick.mowen.adtproject.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nick.mowen.adtproject.R
import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.character.CharacterPresenter
import com.nick.mowen.adtproject.characterlist.CharacterListAdapter
import com.nick.mowen.adtproject.databinding.DialogCharacterLocationBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity

class CharacterLocationDialog(private val selectedCharacter: Character) : BottomSheetDialogFragment() {

    private lateinit var binding: DialogCharacterLocationBinding
    private val viewModel: CharacterLocationViewModel by lazy { ViewModelProvider(this).get(CharacterLocationViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_character_location, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.character = selectedCharacter
        viewModel.getLocation(selectedCharacter.location?.url?.toUri()?.lastPathSegment?.toLongOrNull() ?: -1).observe(viewLifecycleOwner, { binding.location = it })
        binding.residents.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = CharacterListAdapter(
                requireActivity() as AbstractActivity,
                CharacterPresenter(requireActivity() as AbstractActivity)
            ).also { adapter -> viewModel.getLocationResidents().observe(viewLifecycleOwner, {
                adapter.submitList(it)
                binding.residentsLoading.isGone = true
            }) }
        }
    }

    companion object {

        const val FRAGMENT_TAG = "character_location"
    }
}