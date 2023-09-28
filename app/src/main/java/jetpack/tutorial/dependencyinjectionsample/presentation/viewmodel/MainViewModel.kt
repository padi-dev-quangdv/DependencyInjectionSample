package jetpack.tutorial.dependencyinjectionsample.presentation.viewmodel

import MovieResponse
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel
import jetpack.tutorial.dependencyinjectionsample.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
): ViewModel() {

    private val coroutineScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.IO)
    }

    private var insertMovieJob: Job? = null
    private var deleteMovieJob: Job? = null

    val resultFromServer: Flow<MovieResponse> = repository.fetchDataServer()

    private val _movieDbList = MutableStateFlow<List<MovieDbModel>>(listOf())
    val movieDbList: Flow<List<MovieDbModel>>
        get() = _movieDbList.asStateFlow()

    fun getMoviesDb() {
        repository.getAllMoviesDb().onEach {
            _movieDbList.value = it
        }.launchIn(coroutineScope)
    }

    fun addMovieToDb(movieDbModel: MovieDbModel) {
        insertMovieJob?.cancel()
        insertMovieJob = coroutineScope.launch {
            repository.insertMovieToDb(movieDbModel)
        }
    }

    fun deleteMovieToDb(movieDbModel: MovieDbModel) {
        deleteMovieJob?.cancel()
        deleteMovieJob = coroutineScope.launch {
            repository.deleteMovieFromDb(movieDbModel)
        }
    }

    override fun onCleared() {
        super.onCleared()
        insertMovieJob?.cancel()
        deleteMovieJob?.cancel()
    }
}