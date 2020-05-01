package com.rickandmorty.common.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}