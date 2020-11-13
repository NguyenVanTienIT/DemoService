package com.example.demoservice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demoservice.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_to_alarm.setOnClickListener {
            findNavController().navigate(R.id.main_to_alarm)
        }
        btn_to_foreground_service.setOnClickListener {
            findNavController().navigate(R.id.main_to_foreground)
        }
        btn_to_intent_service.setOnClickListener {
            findNavController().navigate(R.id.main_to_intent)
        }
        btn_to_bound_service.setOnClickListener {
            findNavController().navigate(R.id.main_to_bound)
        }
    }
}