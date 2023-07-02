package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        setButtonListener()
    }

    private fun setButtonListener() {
        val name = this.javaClass.simpleName
        binding?.run {
            btnToPhoto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileFragment_to_photoFragment,
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
