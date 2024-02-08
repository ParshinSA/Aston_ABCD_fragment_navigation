package com.example.aston_base_fragment_navigation_abcd.comon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<BaseFrgViewBinding : ViewBinding>(
    private val bindingInflater: (layoutInflater: LayoutInflater) -> BaseFrgViewBinding
) : Fragment() {

    private var _binding: BaseFrgViewBinding? = null
    protected val binding get() = checkNotNull(_binding)

    protected val navigationController by lazy {
        (parentFragment as? NavigationController)
            ?: (requireActivity() as? NavigationController)
            ?: throw RuntimeException("Parent must implements the NavigationController interface")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingsTransition()
    }

    abstract fun settingsTransition()
}
