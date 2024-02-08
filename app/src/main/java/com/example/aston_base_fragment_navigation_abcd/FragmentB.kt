package com.example.aston_base_fragment_navigation_abcd

import com.example.aston_base_fragment_navigation_abcd.comon.BaseFragment
import com.example.aston_base_fragment_navigation_abcd.databinding.FragmentBBinding

class FragmentB : BaseFragment<FragmentBBinding>(FragmentBBinding::inflate) {

    override fun settingsTransition() {
        settingToFragmentA()
        settingToFragmentC()
    }

    private fun settingToFragmentC() {
        binding.btnToFragmentA.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentA.TAG_FRG)
        }
    }

    private fun settingToFragmentA() {
        binding.btnToFragmentC.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentC.TAG_FRG)
        }
    }

    companion object {
        const val TAG_FRG = "FragmentB"

        fun newInstance() = FragmentB()
    }
}