package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        setButtonListener()
    }

    private fun setButtonListener() {
        val name = this.javaClass.simpleName
        print(name)
        binding?.run {
            btnToPhoto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settingsFragment_to_photoFragment,
                    PhotoFragment.createBundle(name)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
