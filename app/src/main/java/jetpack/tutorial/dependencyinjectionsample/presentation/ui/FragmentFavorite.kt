package jetpack.tutorial.dependencyinjectionsample.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jetpack.tutorial.dependencyinjectionsample.databinding.FragmentFavoriteBinding
import jetpack.tutorial.dependencyinjectionsample.presentation.adpater.MovieLocalAdapter
import jetpack.tutorial.dependencyinjectionsample.presentation.utils.gone
import jetpack.tutorial.dependencyinjectionsample.presentation.utils.visible
import jetpack.tutorial.dependencyinjectionsample.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentFavorite: Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MovieLocalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.progressBar.visible()
        viewModel.getMoviesDb()
        initObserver()
    }

    private fun initObserver() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.movieDbList.collectLatest {
                Log.d("Main","$it")
                adapter = MovieLocalAdapter(it) { movie ->
                    viewModel.deleteMovieToDb(movie)
                    Toast.makeText(context, "Remove ${movie.name} from favorite list", Toast.LENGTH_SHORT).show()
                }
                binding.rcvMovieRemote.layoutManager = LinearLayoutManager(context)
                binding.rcvMovieRemote.adapter = adapter
                binding.progressBar.gone()
            }
        }
    }
}