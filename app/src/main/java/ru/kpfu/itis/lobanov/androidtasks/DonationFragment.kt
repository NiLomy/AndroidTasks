package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentDonationBinding

class DonationFragment : Fragment(R.layout.fragment_donation) {
    private var binding: FragmentDonationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDonationBinding.bind(view)
        setButtonListener()
    }

    private fun setButtonListener() {
        val name = this.javaClass.simpleName
        binding?.run {
            btnToPhoto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_donationFragment_to_photoFragment,
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
