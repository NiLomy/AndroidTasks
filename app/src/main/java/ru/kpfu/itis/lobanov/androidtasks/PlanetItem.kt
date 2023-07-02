package ru.kpfu.itis.lobanov.androidtasks

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.kpfu.itis.lobanov.androidtasks.databinding.ItemCityBinding

class PlanetItem(
    private val binding: ItemCityBinding,
    private val glide: RequestManager,
    private val onItemClick: (Planet) -> Unit,
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    fun onBind(planet: Planet) {
        binding.run {
            tvTitle.text = planet.name

            glide
                .load(planet.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(planet)
            }
        }
    }
}
