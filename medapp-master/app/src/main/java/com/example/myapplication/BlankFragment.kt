package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.datastore.dataStore
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController


class BlankFragment : Fragment(R.layout.fragment_blank) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button  = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
           findNavController().navigate(R.id.action_blankFragment_to_fragmentLogin)
        }
        val buttonn = view.findViewById<Button>(R.id.butt)
        buttonn.setOnClickListener{
            findNavController().navigate(R.id.action_blankFragment_to_fragment_Registration)
        }

    }
}