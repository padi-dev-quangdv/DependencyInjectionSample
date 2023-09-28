package jetpack.tutorial.dependencyinjectionsample.presentation.adpater

import Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jetpack.tutorial.dependencyinjectionsample.databinding.ItemMovieRemoteBinding

class MovieRemoteAdapter(
    private val movies: List<Movie>,
    private val onLikeMovieClicked: (Movie) -> Unit,
) : RecyclerView.Adapter<MovieRemoteAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemMovieRemoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                tvName.text = movie.title
                tvVoteAverage.text = movie.voteAverage.toString()
                tvVoteCount.text = movie.voteCount.toString()
                ivLike.setOnClickListener {
                    onLikeMovieClicked(movie)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieRemoteBinding.inflate(LayoutInflater.from(parent.context))
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