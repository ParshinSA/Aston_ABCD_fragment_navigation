package com.example.aston_base_fragment_navigation_abcd

import com.example.aston_base_fragment_navigation_abcd.comon.BaseFragment
import com.example.aston_base_fragment_navigation_abcd.databinding.FragmentABinding

class FragmentA : BaseFragment<FragmentABinding>(FragmentABinding::inflate) {

    override fun settingsTransition() {
        settingsToFragmentB()
    }

    private fun settingsToFragmentB() {
        binding.btnToFragmentB.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentB.TAG_FRG)
        }
    }

    companion object {
        const val TAG_FRG = "FragmentA"

        fun newInstance() = FragmentA()
    }
}