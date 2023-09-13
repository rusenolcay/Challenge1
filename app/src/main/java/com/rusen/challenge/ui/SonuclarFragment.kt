package com.rusen.challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.rusen.challenge.databinding.FragmentSonuclarBinding

class SonuclarFragment : Fragment() {

    private lateinit var binding: FragmentSonuclarBinding
    private val bundle: SonuclarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSonuclarBinding.inflate(inflater, container, false)
        activity?.onBackPressedDispatcher?.addCallback(this) {
            navigateGirisFragment(binding.root)
        }
        binding.button.setOnClickListener {
            navigateGirisFragment(it)
        }
        showCustomPerson()
        return binding.root
    }

    private fun navigateGirisFragment(view: View) {
        Navigation.findNavController(view)
            .navigate(SonuclarFragmentDirections.actionSonuclarFragmentToGirisFragment())
    }

    private fun showCustomPerson() {
        val customPerson = bundle.customPerson
        val name = customPerson.person.name
        val surname = customPerson.person.surname
        with(binding) {
            tvNameSurname.text = "$name $surname"
            tvMail.text = customPerson.person.mail
            tvPhone.text = customPerson.person.phone
            tvAnswer1.text = customPerson.answer1
            tvAnswer2.text = customPerson.answer2
            tvAnswer3.text = customPerson.answer3
        }
    }
}