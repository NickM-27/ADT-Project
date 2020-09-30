package com.nick.mowen.adtproject.extension

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.databinding.ViewDataBinding
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.databinding.FragmentCharacterListBinding

private fun Context.hideSystemShadows() {
    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && this is Activity)
            window.isNavigationBarContrastEnforced = false
    } catch (e: NoSuchMethodError) {
    }
}

fun ViewDataBinding.themeBinding(context: Context) {

    when (this) {
        is ActivityMainBinding -> {
            context.hideSystemShadows()
        }
        is FragmentCharacterListBinding -> {

        }
    }
}