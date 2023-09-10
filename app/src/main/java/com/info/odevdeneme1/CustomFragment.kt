package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.info.odevdeneme1.databinding.FragmentCustomBinding

class CustomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCustomBinding.inflate(inflater, container, false)
        binding.btnCustom.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_customFragment_to_sonuclarFragment)
        }
        return binding.root
    }
}