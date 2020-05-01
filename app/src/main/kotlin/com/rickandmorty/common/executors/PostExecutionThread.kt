package com.mobilechallenge.common.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}