package com.rusen.challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.rusen.challenge.data.Person
import com.rusen.challenge.databinding.FragmentKisiselBilgilerBinding
import com.rusen.challenge.showToast

class KisiselBilgilerFragment : Fragment() {

    private lateinit var binding: FragmentKisiselBilgilerBinding
    val bundle: KisiselBilgilerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKisiselBilgilerBinding.inflate(inflater, container, false)
        init()
        showGreetingMessage()
        return binding.root
    }

    private fun init() {
        with(binding) {
            btnKisiselBilgi.setOnClickListener {
                if (etMail.text.isBlank() || etPhone.text.isBlank()) {
                    context?.showToast()
                } else {
                    navigateCustomFragment(it)
                }
            }
        }
    }

    private fun navigateCustomFragment(view: View) {
        val person = Person(
            name = bundle.name,
            surname = bundle.surname,
            phone = binding.etPhone.text.toString(),
            mail = binding.etMail.text.toString()
        )
        val navDirections =
            KisiselBilgilerFragmentDirections.actionKisiselBilgilerFragmentToCustomFragment(person)
        Navigation.findNavController(view).navigate(navDirections)
    }

    private fun showGreetingMessage() {
        val name = bundle.name
        val surname = bundle.surname
        binding.tvKarsilamaMesaji.text = "Merhaba, $name $surname;"
    }
}

