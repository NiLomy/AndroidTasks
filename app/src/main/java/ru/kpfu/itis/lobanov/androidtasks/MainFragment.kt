package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    private var adapter: PlanetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            list = PlanetRepository.list,
            glide = Glide.with(this),
            onItemClick = { city ->
                findNavController().navigate(
                    R.id.action_mainFragment_to_infoFragment,
                    InfoFragment.createBundle(city.id)
                )
            }
        )
        binding?.rvCity?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
