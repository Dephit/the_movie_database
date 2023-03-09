package com.sergeenko.themoviedatabase.screens.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sergeenko.themoviedatabase.databinding.FragmentProfilePageBinding

class ProfileFragment: Fragment() {

    private val binding by lazy {
        FragmentProfilePageBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}