package com.nick.mowen.adtproject.skeleton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.nick.mowen.adtproject.extension.activateTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class AbstractActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    protected abstract val binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        activateTheme()
        super.onCreate(savedInstanceState)
    }

    abstract protected fun bindViews()
}