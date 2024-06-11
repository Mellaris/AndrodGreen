package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.dataStore
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplication.network.DataStoreManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class SpalshScreen : Fragment(R.layout.fragment_spalsh_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//                              findNavController().navigate(R.id.action_spalshScreen_to_blankFragment)
        val dataStoreManager = DataStoreManager(requireContext())
        lifecycleScope.launch {
            dataStoreManager.tokenflow.collect{
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                if (it.isEmpty())
                {
                    findNavController().navigate(R.id.action_spalshScreen_to_blankFragment)
                }
                else{
                    findNavController().navigate(R.id.action_spalshScreen_to_fragment_Main)
                }
            }
        }

    }

}