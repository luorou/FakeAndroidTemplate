package com.bye.ane.feature.index.present.vm

import android.util.Log
import com.bye.ane.feature.index.present.contract.IndexEffect
import com.bye.ane.feature.index.present.contract.IndexState
import com.bye.ane.feature.index.repository.IndexRepository
import com.bye.ane.feature.login.port.repository.LoginExposeRepository
import com.bye.ane.shared.mvi.vm.OrbitVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IndexVM @Inject constructor(
    private val loginExposeRepository: LoginExposeRepository,
    private val indexRepository: IndexRepository
) :
    OrbitVM<IndexState, IndexEffect>() {
    override fun initState(): IndexState {
        return IndexState()
    }

    //
    fun login() = intent {
        val name = indexRepository.login()
        Log.e("login", "name")
    }
}