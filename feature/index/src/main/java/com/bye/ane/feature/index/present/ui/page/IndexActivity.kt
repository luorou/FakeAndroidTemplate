package com.bye.ane.feature.index.present.ui.page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.viewpager2.widget.ViewPager2
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.bye.ane.core.widget.tab.ColorMode
import com.bye.ane.core.widget.tab.DslBottomTabItemView
import com.bye.ane.feature.index.databinding.IndexActivityBinding
import com.bye.ane.feature.index.present.contract.IndexEffect
import com.bye.ane.feature.index.present.contract.IndexState
import com.bye.ane.feature.index.present.ui.vp.IndexVpAdapter
import com.bye.ane.feature.index.present.vm.IndexVM
import com.bye.ane.shared.mvi.ui.activity.OrbitMviActivity
import com.yenaly.circularrevealswitch.SwitchAnimation
import com.yenaly.circularrevealswitch.ext.setDayNightModeSwitcher
import com.zackratos.ultimatebarx.ultimatebarx.java.UltimateBarX
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

        mBind.tv.setDayNightModeSwitcher(
            duration = 400L,
            interpolator = FastOutSlowInInterpolator(),
            animToDayMode = SwitchAnimation.SHRINK, // 前往日间模式的动画
            animToNightMode = SwitchAnimation.EXPAND, // 前往夜间模式的动画
            onNightModeAnimStart = { },
            onNightModeAnimEnd = { },
            onDayModeAnimStart = { },
            onDayModeAnimEnd = { },
            onClick = { },
        )
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