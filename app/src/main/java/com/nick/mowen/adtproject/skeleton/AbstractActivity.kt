package com.nick.mowen.adtproject.skeleton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class AbstractActivity : AppCompatActivity() {

    protected abstract val binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    abstract protected fun bindViews()
}