package com.bye.ane.feature.index.present.ui.page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.viewpager2.widget.ViewPager2
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.bye.ane.core.widget.tab.ColorMode
import com.bye.ane.core.widget.tab.DslBottomTabItemView
import com.bye.ane.feature.index.R
import com.bye.ane.feature.index.databinding.IndexActivityBinding
import com.bye.ane.feature.index.present.contract.IndexEffect
import com.bye.ane.feature.index.present.contract.IndexState
import com.bye.ane.feature.index.present.ui.vp.IndexVpAdapter
import com.bye.ane.feature.index.present.vm.IndexVM
import com.bye.ane.shared.mvi.ui.activity.OrbitMviActivity
import com.example.xlulibrary.Location
import com.example.xlulibrary.ToastBox
import com.example.xlulibrary.ToastTextStyle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IndexActivity : OrbitMviActivity<
        IndexState,
        IndexEffect,
        IndexVM,
        IndexActivityBinding
        >() {


    override val VM: IndexVM by viewModels()

    override fun initVBAndGetRootView(): View {
        this.mBind = IndexActivityBinding.inflate(layoutInflater)
        return mBind.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(mBind.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, systemBars.bottom)
            insets
        }
        initView()
        initListener()
    }


    /**
     *
     */
    private fun initView() {

        buildSlice()
        VM.login()
    }

    /**
     *
     */
    private fun buildSlice() {
        //
        mBind.vp.isUserInputEnabled = false
        //
        mBind.vp.offscreenPageLimit = 4
        //
        mBind.vp.adapter = IndexVpAdapter(supportFragmentManager, lifecycle)

        mBind.vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                changeTabUI(position)
            }
        })
        //
        mBind.tabHome.refreshStatus(true, ColorMode.WHITE)
        //
        ViewPager2Delegate.install(mBind.vp, mBind.bottomBar, false)
        //
    }

    private fun changeTabUI(position: Int) {
        mBind.bottomBar.children.forEachIndexed { index, view ->
            if (view !is DslBottomTabItemView) {
                return
            }
            val selected = position == index
            view as DslBottomTabItemView
            view.refreshStatus(selected, ColorMode.WHITE)
        }
    }

    /**
     *
     */
    private fun initListener() {

    }

    override fun renderWithState(state: IndexState) {

    }

    override fun renderWithEffect(eff: IndexEffect) {

    }
}