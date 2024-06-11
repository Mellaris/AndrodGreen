package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController


class fragment_Registration : Fragment(R.layout.fragment__registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button  = view.findViewById<Button>(R.id.back)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_fragmentLogin)
        }
    }
}