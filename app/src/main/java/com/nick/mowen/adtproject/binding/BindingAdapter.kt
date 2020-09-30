package com.nick.mowen.adtproject.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.setImageUrl(url: String?) {
        url ?: return
        load(url) {
            crossfade(true)
        }
    }
}