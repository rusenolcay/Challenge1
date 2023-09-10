package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.info.odevdeneme1.databinding.FragmentGirisBinding

class GirisFragment : Fragment() {

    private lateinit var binding: FragmentGirisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGirisBinding.inflate(inflater, container, false)
        binding.btnGiris.setOnClickListener {
            navigateKisiselBilgiler(it)
        }
        return binding.root
    }

    private fun navigateKisiselBilgiler(view: View) {
        val name = binding.etName.text.toString()
        val surname = binding.etSurname.text.toString()

        val navDirections =
            GirisFragmentDirections.actionGirisFragmentToKisiselBilgilerFragment(name, surname)
        Navigation.findNavController(view).navigate(navDirections)
    }
}