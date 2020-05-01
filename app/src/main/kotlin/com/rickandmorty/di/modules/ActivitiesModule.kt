package com.mobilechallenge.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.mobilechallenge.di.modules.fragments.AuthenticationActivityFragmentsBuildersModule
import com.mobilechallenge.di.modules.fragments.OnboardingFragmentBuildersModule
import com.mobilechallenge.scenes.authentication.AuthenticationActivity
import com.mobilechallenge.scenes.onboarding.splash.OnboardingActivity
import com.mobilechallenge.scenes.onboarding.splash.SplashActivity

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [(AuthenticationActivityFragmentsBuildersModule::class)])
    abstract fun contributeAuthenticationActivityInjector(): AuthenticationActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivityInjector(): SplashActivity

    @ContributesAndroidInjector(modules = [(OnboardingFragmentBuildersModule::class)])
    abstract fun contributeOnboardingActivityInjector(): OnboardingActivity

}