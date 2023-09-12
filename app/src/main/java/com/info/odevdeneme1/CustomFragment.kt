package com.info.odevdeneme1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.info.odevdeneme1.databinding.FragmentCustomBinding

class CustomFragment : Fragment() {
    private lateinit var binding: FragmentCustomBinding
    private val bundle: CustomFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomBinding.inflate(inflater, container, false)
        binding.btnCustom.setOnClickListener {
            navigateSonuclarFragment(it)
        }
        showGreetingMessage()
        return binding.root
    }

    private fun navigateSonuclarFragment(view: View) {
        val customPerson = CustomPerson(
            person = bundle.person,
            answer1 = binding.etAnswer1.text.toString(),
            answer2 = binding.etAnswer2.text.toString(),
            answer3 = binding.etAnswer3.text.toString()
        )
        val navDirections =
            CustomFragmentDirections.actionCustomFragmentToSonuclarFragment(customPerson)
        Navigation.findNavController(view).navigate(navDirections)
    }

    private fun showGreetingMessage() {
        val name = bundle.person.name
        val surname = bundle.person.surname
        binding.tvKarsilamaMesaji.text = "Merhaba, $name $surname"
    }
}