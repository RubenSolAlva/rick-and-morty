package com.rickandmorty.scenes.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rickandmorty.R
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import com.rickandmorty.common.BaseActivity
import javax.inject.Inject

class AuthenticationActivity: BaseActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
    }

}