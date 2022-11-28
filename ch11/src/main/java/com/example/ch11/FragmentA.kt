package com.example.ch11

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    var activityCallback: ButtonListener? = null
    interface ButtonListener {
        fun onButtonClick()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_a, container, false)
        val button: Button = rootView.findViewById(R.id.button)

//        인터페이스를 상속받은 객체에서 구현한 메소드 호출
        button.setOnClickListener {
            activityCallback?.onButtonClick()
        }
        return rootView
    }

//    인터페이스를 구현 상속한 객체가 맞는지 확인
//     맞으면 이 객체의 type으로 변환
//     이 객체는 화면(context)을 갖는 객체
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ButtonListener) {
                activityCallback = context
            }
        } catch (e:ClassCastException) {
            throw ClassCastException(context.toString()
                    + " must implement buttonListener")
        }
    }
}
