package com.bye.ane.shared.mvi.ui.frgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class VBFragment<VB : ViewBinding> : Fragment() {

    /**
     *
     */
    lateinit var mBind: VB

    /**
     *
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initVBAndGetRootView(layoutInflater)
    }


    abstract fun initVBAndGetRootView(layoutInflater: LayoutInflater): View


}