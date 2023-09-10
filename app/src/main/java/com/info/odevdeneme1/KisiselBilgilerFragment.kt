package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.info.odevdeneme1.databinding.FragmentKisiselBilgilerBinding

class KisiselBilgilerFragment : Fragment() {

    private lateinit var binding: FragmentKisiselBilgilerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKisiselBilgilerBinding.inflate(inflater, container, false)

        binding.btnKisiselBilgi.setOnClickListener {
            navigateCustomFragment(it)
        }

        showGreetingMessage()
        return binding.root
    }

    private fun navigateCustomFragment(view: View) {
        Navigation.findNavController(view)
            .navigate(R.id.action_kisiselBilgilerFragment_to_customFragment)
    }

    private fun showGreetingMessage() {
        val bundle: KisiselBilgilerFragmentArgs by navArgs()
        val name = bundle.name
        val surname = bundle.surname
        binding.tvKarsilamaMesaji.text = "Merhaba, $name $surname;"
    }
}

