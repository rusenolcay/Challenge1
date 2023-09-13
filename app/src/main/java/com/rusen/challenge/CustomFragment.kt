package com.rusen.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.rusen.challenge.databinding.FragmentCustomBinding

class CustomFragment : Fragment() {
    private lateinit var binding: FragmentCustomBinding
    private val bundle: CustomFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomBinding.inflate(inflater, container, false)
        init()
        showGreetingMessage()
        return binding.root
    }

    private fun init() {
        binding.btnCustom.setOnClickListener {
            attemptValidation(it)
        }
        binding.linearlayout.setOnClickListener {
            hideKeyboard()
        }
    }

    private fun attemptValidation(view: View) {
        if (isValid()) {
            navigateSonuclarFragment(view)
        } else {
            context?.showToast()
            Toast.makeText(context, getString(R.string.uyari), Toast.LENGTH_SHORT).show()
        }
    }

    // eğer herhangi bir alan boş ise false dönderir, eğer hepsi doluysa true dönderir.
    private fun isValid() = with(binding) {
        etAnswer1.text.isNotBlank() && etAnswer2.text.isNotBlank() && etAnswer3.text.isNotBlank()
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