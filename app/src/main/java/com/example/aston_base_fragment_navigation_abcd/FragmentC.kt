package com.example.aston_base_fragment_navigation_abcd

import android.os.Bundle
import android.view.View
import com.example.aston_base_fragment_navigation_abcd.comon.BaseFragment
import com.example.aston_base_fragment_navigation_abcd.databinding.FragmentCBinding

class FragmentC : BaseFragment<FragmentCBinding>(FragmentCBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveAndSetMessage()
    }

    private fun retrieveAndSetMessage() {
        val message = requireArguments().getString(KEY_MESSAGE) ?: "ERROR"
        binding.tVMessageInput.text = message
    }

    override fun settingsTransition() {
        settingToFragmentA()
        settingToFragmentD()
    }

    private fun settingToFragmentD() {
        binding.btnToFragmentD.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentD.TAG_FRG)
        }
    }

    private fun settingToFragmentA() {
        binding.btnToFragmentA.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentA.TAG_FRG)
        }
    }

    companion object {
        const val TAG_FRG = "FragmentC"

        private const val KEY_MESSAGE = "KEY_MESSAGE"

        fun newInstance(message: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(KEY_MESSAGE, message)
            }
        }
    }
}