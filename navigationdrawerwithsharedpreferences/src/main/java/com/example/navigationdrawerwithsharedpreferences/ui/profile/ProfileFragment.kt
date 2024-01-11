package com.example.navigationdrawerwithsharedpreferences.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.navigationdrawerwithsharedpreferences.databinding.FragmentProfileBinding
import com.example.navigationdrawerwithsharedpreferences.utils.PreferencesManager

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    val profileViewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitialData()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        saveButton.setOnClickListener {
            PreferencesManager.currentUserName = nameEditText.text.toString()
        }
    }

    private fun setInitialData(): Unit = with(binding) {
        nameEditText.setText(PreferencesManager.currentUserName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}