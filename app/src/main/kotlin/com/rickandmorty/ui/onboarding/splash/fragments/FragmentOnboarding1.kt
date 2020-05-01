package com.rickandmorty.scenes.onboarding.splash.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rickandmorty.R
import com.rickandmorty.common.BaseFragment
import com.rickandmorty.scenes.authentication.AuthenticationActivity
import com.rickandmorty.scenes.onboarding.splash.OnboardingActivity
import kotlinx.android.synthetic.main.fragment_onboarding1.*
import org.jetbrains.anko.sdk23.listeners.onClick


class FragmentOnboarding1 : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_onboarding1, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()

        btnNext.onClick { nextPage() }
        btnSkip.onClick { skipOnboarding() }
    }

    fun skipOnboarding(){
        val intentToLogin = Intent(context, AuthenticationActivity::class.java)
        startActivity(intentToLogin)
        (activity as OnboardingActivity).finish()
    }

    fun nextPage(){
        (activity as OnboardingActivity).changeViewPagerPage(1)
    }
}