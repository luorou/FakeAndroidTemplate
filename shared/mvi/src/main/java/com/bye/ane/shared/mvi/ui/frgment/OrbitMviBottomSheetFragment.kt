package com.bye.ane.shared.mvi.ui.frgment

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.bye.ane.shared.mvi.ui.OrbitMviUIContainer
import com.bye.ane.shared.mvi.vm.OrbitVM
import org.orbitmvi.orbit.viewmodel.observe

abstract class OrbitMviBottomSheetFragment<STATE : Any, EFF : Any, VM : OrbitVM<STATE, EFF>, VB : ViewBinding> :
    OrbitMviUIContainer<STATE, EFF>, VBBottomSheetFragment<VB>() {
    abstract val VM: VM
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        VM.observe(this, state = ::renderWithState, sideEffect = ::renderWithEffect)
    }
}