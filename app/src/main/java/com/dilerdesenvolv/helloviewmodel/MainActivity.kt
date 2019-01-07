package com.dilerdesenvolv.helloviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    Fragment
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btCount.setOnClickListener { onClickCount() }
//    }
//
//    private fun onClickCount() {
//        val frag
//                = supportFragmentManager.findFragmentById(R.id.HelloFragment) as HelloFragment
//        frag.incrementar()
//    }


    private lateinit var model: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this).get(CountViewModel::class.java)
        setCount(model.count)

        model.startTimer()
        lifecycle.addObserver(model)
        val observer: Observer<Int> = Observer { count ->
            setCount(count!!)
        }
        model.getCount().observe(this, observer)

//        btCount.setOnClickListener { onClickCount() }
    }

    private fun onClickCount() {
        // Incrementar
        val s = tCount.text.toString()
        var i = 0
        i = if ("" == s) {
            0
        } else {
            Integer.parseInt(s)
        }
        setCount(++i)
    }

    private fun setCount(i: Int) {
        model.count = i
        tCount.text = (i).toString()
        Log.d("up", "count $i")
    }

}

