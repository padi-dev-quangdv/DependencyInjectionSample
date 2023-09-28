package jetpack.tutorial.dependencyinjectionsample.presentation.utils

import Movie
import android.view.View
import jetpack.tutorial.dependencyinjectionsample.data.local.entity.MovieDbModel

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Movie.parseToDbModel(): MovieDbModel {
    return MovieDbModel(
        name = this.title,
        publicationDate =  this.releaseDate
    )
}