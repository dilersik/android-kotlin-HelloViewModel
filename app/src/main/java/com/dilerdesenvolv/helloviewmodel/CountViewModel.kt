package com.dilerdesenvolv.helloviewmodel

import android.arch.lifecycle.*
import android.util.Log
import java.util.*

class CountViewModel : ViewModel(), LifecycleObserver {

    var count = 0

    private lateinit var timer: Timer
    var liveData: MutableLiveData<Int> = MutableLiveData()

    fun startTimer() {
        timer = Timer()
        timer.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
                count ++

                liveData.postValue(count)

                Log.d("cTimer", "count $count")
            }

        }, 1000, 1000)
    }

    fun getCount(): LiveData<Int> {
        return liveData
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d("lfEvent", "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("lfEvent", "onPause")
    }

}