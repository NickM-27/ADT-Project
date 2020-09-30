package com.nick.mowen.adtproject.extension

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.databinding.ViewDataBinding
import androidx.preference.PreferenceManager
import com.nick.mowen.adtproject.databinding.ActivityMainBinding
import com.nick.mowen.adtproject.databinding.FragmentCharacterListBinding
import com.nick.mowen.adtproject.skeleton.AbstractActivity

private fun Context.hideSystemShadows() {
    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && this is Activity)
            window.isNavigationBarContrastEnforced = false
    } catch (e: NoSuchMethodError) {
    }
}

fun AbstractActivity.toggleTheme() {
    PreferenceManager.getDefaultSharedPreferences(this).let { prefs ->
        if (prefs.getString("appTheme", "Automatic Mode") == "Day Mode") {
            prefs.edit { putString("appTheme", "Night Mode") }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            prefs.edit { putString("appTheme", "Day Mode") }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}

fun AbstractActivity.activateTheme() =
    when (PreferenceManager.getDefaultSharedPreferences(this).getString("appTheme", "Automatic Mode")) {
        "Day Mode" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        "Night Mode" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

fun ViewDataBinding.themeBinding(context: Context) {

    when (this) {
        is ActivityMainBinding -> {
            context.hideSystemShadows()

            if (context is AppCompatActivity)
                context.setSupportActionBar(toolbar)
        }
        is FragmentCharacterListBinding -> {

        }
    }
}