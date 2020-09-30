package com.nick.mowen.adtproject.character

import com.nick.mowen.adtproject.location.CharacterLocationDialog
import com.nick.mowen.adtproject.skeleton.AbstractActivity
import com.nick.mowen.adtproject.skeleton.AbstractPresenter

class CharacterPresenter(private val context: AbstractActivity) : AbstractPresenter(context) {

    fun onCharacterClicked(character: Character) {
        CharacterLocationDialog(character).show(context.supportFragmentManager, CharacterLocationDialog.FRAGMENT_TAG)
    }
}