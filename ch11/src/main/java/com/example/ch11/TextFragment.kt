package com.example.ch11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

//class TextFragment : Fragment() {
//    lateinit var textView: TextView
//    override fun onCreateView(inflater: LayoutInflater,
//                              container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_text, container, false)
//        textView = rootView.findViewById(R.id.textView)
//        return rootView
//    }
//
//    fun changeTextProperties(fontSize:Int, text:String) {
//        textView.textSize = fontSize.toFloat()
//        textView.text = text
//    }
//}

class TextFragment : Fragment() {
    lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textView_fragment)

        val commonDataViewModel = ViewModelProviders.of(requireActivity()).get(CommonDataViewModel::class.java)

        commonDataViewModel.getTextData().observe(viewLifecycleOwner, Observer {
            textView.text = it as CharSequence
        })
        commonDataViewModel.getTextSizeData().observe(viewLifecycleOwner, Observer {
            textView.textSize = it as Float
        })
    }
}
