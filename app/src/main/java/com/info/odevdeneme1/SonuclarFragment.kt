package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.info.odevdeneme1.databinding.FragmentSonuclarBinding

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
        val name = bundle.customPerson.person.name
        val surname = bundle.customPerson.person.surname
        binding.tvNameSurname.text = "$name $surname"
        binding.tvMail.text = bundle.customPerson.person.mail
        binding.tvPhone.text = bundle.customPerson.person.phone
        binding.tvAnswer1.text = bundle.customPerson.answer1
        binding.tvAnswer2.text = bundle.customPerson.answer2
        binding.tvAnswer3.text = bundle.customPerson.answer3
    }
}