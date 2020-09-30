package com.nick.mowen.adtproject.skeleton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class AbstractFragment : Fragment() {

    protected abstract val binding: ViewDataBinding

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflateViews(layoutInflater, container)
        return binding.root
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    abstract fun inflateViews(layoutInflater: LayoutInflater, parent: ViewGroup?)

    abstract fun bindViews()
}