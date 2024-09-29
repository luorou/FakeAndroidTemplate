package com.bye.ane.shared.mvi.ui

interface OrbitMviUIContainer<STATE : Any, EFF : Any> {

    fun renderWithState(state: STATE)

    fun renderWithEffect(eff: EFF)
}