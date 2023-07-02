package ru.kpfu.itis.lobanov.androidtasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.kpfu.itis.lobanov.androidtasks.databinding.FragmentInfoBinding

class InfoFragment: Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        val planet = getInfo()
        setInfo(planet)
        setImage(planet)
    }

    private fun getInfo(): Planet {
        val id = arguments?.getInt(ARG_ID)
        return PlanetRepository.list.single {it.id == id}
    }

    private fun setInfo(planet: Planet) {
        binding?.tvId?.text = "ID: ${planet.id}"
        binding?.tvName?.text = "Name: ${planet.name}"
        binding?.tvDesc?.text = "Desc: ${planet.desc}"
    }

    private fun setImage(planet: Planet) {
        binding?.imageView?.let {
            Glide.with(this)
                .load(planet.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, id)
            return bundle
        }
    }
}