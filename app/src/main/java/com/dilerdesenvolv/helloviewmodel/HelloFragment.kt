package com.dilerdesenvolv.helloviewmodel


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hello.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HelloFragment : Fragment() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello,
                container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCount(count)
    }

    fun incrementar() {
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
        this.count = i
        tCount.text = (i).toString()
        Log.d("up", "count $i")
    }

}

