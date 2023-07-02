package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        setButtonListener()
    }

    private fun setButtonListener() {
        val name = this.javaClass.simpleName
        binding?.run {
            btnToPhoto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_mainFragment_to_photoFragment,
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
