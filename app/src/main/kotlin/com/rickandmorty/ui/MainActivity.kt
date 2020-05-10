package com.rickandmorty.ui

import android.os.Bundle
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import com.rickandmorty.R
import com.rickandmorty.common.BaseActivity
import com.rickandmorty.ui.viewmodels.MainViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.progress_layout.*
import androidx.navigation.Navigation


class MainActivity :  BaseActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> = fragmentInjector
    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        progressLayout = progressContainer
        setNetworkListener(this)
        bindViewModel()
        setupNavigationController()
    }

    /**
     * Bind viewModel with activity
     */
    private fun bindViewModel() {
        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

    /**
     * If we need a custom toolbar, we can manage it depending fragments
     */
    private fun setupNavigationController() {
        navController = Navigation.findNavController(this, R.id.navigation_host_fragment)
    }
}