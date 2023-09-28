package jetpack.tutorial.dependencyinjectionsample.presentation.adpater

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import jetpack.tutorial.dependencyinjectionsample.databinding.ItemMovieLocalBinding

class MovieLocalAdapter(
    private val movies: List<MovieDbModel>,
    private val onLikeMovieClicked: (MovieDbModel) -> Unit,
) : RecyclerView.Adapter<MovieLocalAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemMovieLocalBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(movie: MovieDbModel) {
            binding.apply {
                tvName.text = movie.name
                tvDateRelease.text = movie.publicationDate
                ivLike.setOnClickListener {
                    onLikeMovieClicked(movie)
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieLocalBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = movies[position]
        holder.bind(currentItem)
    }

}