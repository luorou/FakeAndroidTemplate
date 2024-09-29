package com.bye.ane.shared.mvi.ui.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.bye.ane.shared.mvi.ui.OrbitMviUIContainer
import com.bye.ane.shared.mvi.vm.OrbitVM
import org.orbitmvi.orbit.viewmodel.observe

abstract class OrbitMviActivity<STATE : Any, EFF : Any, VM : OrbitVM<STATE, EFF>, VB : ViewBinding> :
    OrbitMviUIContainer<STATE, EFF>, VBActivity<VB>() {
    abstract val VM: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VM.observe(this, state = ::renderWithState, sideEffect = ::renderWithEffect)
    }
}