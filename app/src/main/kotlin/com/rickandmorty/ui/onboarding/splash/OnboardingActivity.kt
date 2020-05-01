package com.rickandmorty.scenes.onboarding.splash

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.rickandmorty.R
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import com.rickandmorty.common.BaseActivity
import com.rickandmorty.scenes.onboarding.splash.adapter.MyPagerAdapter
import com.rickandmorty.scenes.onboarding.splash.fragments.FragmentOnboarding1
import com.rickandmorty.scenes.onboarding.splash.fragments.FragmentOnboarding2
import com.rickandmorty.scenes.onboarding.splash.fragments.FragmentOnboarding3
import kotlinx.android.synthetic.main.activity_onboarding.*
import javax.inject.Inject


class OnboardingActivity : BaseActivity(), HasSupportFragmentInjector {
    companion object {
        private const val MIN_SCALE = 0.65f
        private const val MIN_ALPHA = 0.3f
    }
    private lateinit var pagerAdapterView: MyPagerAdapter

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        firstDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.colorPrimary, null), PorterDuff.Mode.SRC_IN)
        secondDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
        thirdDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)

        initOnboardingViewPager()
    }


    fun initOnboardingViewPager(){
        pagerAdapterView = MyPagerAdapter(supportFragmentManager)
        addPagerFragments()
        myViewPager.adapter = pagerAdapterView
        myViewPager.setPageTransformer(true, this::zoomOutTransformation)
        myViewPager.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
    }

    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                firstDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.colorPrimary, null), PorterDuff.Mode.SRC_IN)
                firstDotImageView.setImageResource(R.drawable.current_position_icon)

                secondDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                secondDotImageView.setImageResource(R.drawable.disable_position_icon)

                thirdDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                thirdDotImageView.setImageResource(R.drawable.disable_position_icon)
            }
            1 -> {
                firstDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                firstDotImageView.setImageResource(R.drawable.disable_position_icon)

                secondDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.colorPrimary, null), PorterDuff.Mode.SRC_IN)
                secondDotImageView.setImageResource(R.drawable.current_position_icon)

                thirdDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                thirdDotImageView.setImageResource(R.drawable.disable_position_icon)
            }
            2 -> {

                firstDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                firstDotImageView.setImageResource(R.drawable.disable_position_icon)

                secondDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_IN)
                secondDotImageView.setImageResource(R.drawable.disable_position_icon)

                thirdDotImageView.setColorFilter(ResourcesCompat.getColor(resources, R.color.colorPrimary, null), PorterDuff.Mode.SRC_IN)
                thirdDotImageView.setImageResource(R.drawable.current_position_icon)
            }
        }
    }

    private fun addPagerFragments() {
        pagerAdapterView.addFragments(FragmentOnboarding1())
        pagerAdapterView.addFragments(FragmentOnboarding2())
        pagerAdapterView.addFragments(FragmentOnboarding3())
    }

    private fun zoomOutTransformation(page: View, position: Float) {
        when {
            position < -1 ->
                page.alpha = 0f
            position <= 1 -> {
                page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            }
            else -> page.alpha = 0f
        }
    }


    fun changeViewPagerPage(position: Int){
        myViewPager.currentItem = position
    }
}