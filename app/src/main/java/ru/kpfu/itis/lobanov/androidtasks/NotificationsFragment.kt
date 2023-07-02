package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {
    private var binding: FragmentNotificationsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)
        setButtonListener()
    }

    private fun setButtonListener() {
        val name = this.javaClass.simpleName
        binding?.run {
            btnToPhoto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_notificationsFragment_to_photoFragment,
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