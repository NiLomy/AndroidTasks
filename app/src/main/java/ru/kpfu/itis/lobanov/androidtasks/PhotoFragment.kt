package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment(R.layout.fragment_photo) {
    private var binding: FragmentPhotoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoBinding.bind(view)
        showSnackbar()
    }

    private fun showSnackbar() {
        val name = arguments?.getString(ARG_NAME)
        if (name != null) {
            Snackbar.make(binding!!.root, name, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"

        fun createBundle(name: String): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            return bundle
        }
    }
}
