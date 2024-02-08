package com.example.aston_base_fragment_navigation_abcd

import com.example.aston_base_fragment_navigation_abcd.comon.BaseFragment
import com.example.aston_base_fragment_navigation_abcd.databinding.FragmentDBinding

class FragmentD : BaseFragment<FragmentDBinding>(FragmentDBinding::inflate) {

    override fun settingsTransition() {
        settingToFragmentA()
    }

    private fun settingToFragmentA() {
        binding.btnToFragmentB.setOnClickListener {
            navigationController?.openFragmentByTag(FragmentB.TAG_FRG)
        }
    }

    companion object {
        const val TAG_FRG = "FragmentD"

        fun newInstance() = FragmentD()
    }

}