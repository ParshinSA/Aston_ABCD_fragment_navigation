package com.example.aston_base_fragment_navigation_abcd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aston_base_fragment_navigation_abcd.comon.NavigationController

class MainActivity : AppCompatActivity(), NavigationController {

    private val mapNavigationFragmentsByTag = mapOf(
        FragmentA.TAG_FRG to { FragmentA.newInstance() },
        FragmentB.TAG_FRG to { FragmentB.newInstance() },
        FragmentC.TAG_FRG to { FragmentC.newInstance(getString(R.string.message_hello_fragment_c)) },
        FragmentD.TAG_FRG to { FragmentD.newInstance() },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) openFragmentByTag(FragmentA.TAG_FRG)
    }

    override fun openFragmentByTag(fragmentTag: String) {
        var newFragment = supportFragmentManager.findFragmentByTag(fragmentTag)
        val transaction = supportFragmentManager.beginTransaction()

        if (newFragment != null) {
            supportFragmentManager.popBackStack(fragmentTag, 0)
        } else {
            newFragment = mapNavigationFragmentsByTag[fragmentTag]?.invoke()
                ?: throw IllegalArgumentException("Not fragment fond by tag $fragmentTag")
            transaction.replace(R.id.activity_container, newFragment, fragmentTag)
                .addToBackStack(fragmentTag)
        }

        transaction.commit()
    }

}