package com.bye.ane.shared.mvi.ui.frgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class VBBottomSheetFragment<VB : ViewBinding> : BottomSheetDialogFragment() {

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