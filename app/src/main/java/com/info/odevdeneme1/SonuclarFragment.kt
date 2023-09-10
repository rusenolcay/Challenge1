package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.info.odevdeneme1.databinding.FragmentSonuclarBinding

class SonuclarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSonuclarBinding.inflate(inflater, container, false)
        return binding.root
    }
}