package com.example.myapplication

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.datastore.dataStore
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.models.UserRequest
import com.example.myapplication.network.DataStoreManager
import com.example.myapplication.network.RetrofitImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentLogin : Fragment(R.layout.fragment_login) {
    private var binding: FragmentLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        val userResponse = RetrofitImpl.create()
        val button = view.findViewById<Button>(R.id.registr)
        var dataStoreManager = DataStoreManager(requireContext())
        button.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_fragment_Registration)
        }

        binding?.vxod?.setOnClickListener {
            val email = binding?.email?.text.toString()
            val passw = binding?.password?.text.toString()
            val but = view.findViewById<Button>(R.id.vxod)
            if (!email.contains('@')) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            CoroutineScope(Dispatchers.IO).launch {
                val result = userResponse.authorization(UserRequest(email, passw))
                if (result.isSuccessful) {

                    dataStoreManager.saveEmail(email)
                    dataStoreManager.savePassw(passw)
                    if (result.body() != null){
                        dataStoreManager.saveId(result.body()!!.id)
                        dataStoreManager.saveAvatar(result.body()!!.avatar)
                        dataStoreManager.saveToken(result.body()!!.token)

                    }
                    findNavController().navigate(R.id.action_fragmentLogin_to_fragment_Main)
                }

            }

        }

    }
}