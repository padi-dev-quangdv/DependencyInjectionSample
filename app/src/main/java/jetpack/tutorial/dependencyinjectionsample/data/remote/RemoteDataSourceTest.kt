package jetpack.tutorial.dependencyinjectionsample.data.remote

import Movie
import MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceTest @Inject constructor(): RemoteDataSource {
    override fun fetchDataFromRemote(): Flow<MovieResponse> {
        return flow {
            emit(getMockRemoteData())
        }
    }

}

private fun getMockRemoteData(): MovieResponse {
    val movie1 = Movie(
        adult = false,
        backdropPath = "/H6j5smdpRqP9a8UnhWp6zfl0SC.jpg",
        genreIds = listOf(28, 878, 12),
        id = 565770,
        originalLanguage = "en",
        originalTitle = "Blue Beetle",
        overview = "Recent college grad Jaime Reyes returns home full of aspirations for his future, only to find that home is not quite as he left it. As he searches to find his purpose in the world, fate intervenes when Jaime unexpectedly finds himself in possession of an ancient relic of alien biotechnology: the Scarab.",
        popularity = 3180.6,
        posterPath = "/mXLOHHc1Zeuwsl4xYKjKh2280oL.jpg",
        releaseDate = "2023-08-16",
        title = "Blue Beetle",
        video = false,
        voteAverage = 7.2,
        voteCount = 910
    )

    val movie2 = Movie(
        adult = false,
        backdropPath = "/iiXliCeykkzmJ0Eg9RYJ7F2CWSz.jpg",
        genreIds = listOf(28, 9648, 53, 80),
        id = 762430,
        originalLanguage = "en",
        originalTitle = "Retribution",
        overview = "When a mysterious caller puts a bomb under his car seat, Matt Turner begins a high-speed chase across the city to complete a specific series of tasks. With his kids trapped in the back seat and a bomb that will explode if they get out of the car, a normal commute becomes a twisted game of life or death as Matt follows the stranger's increasingly dangerous instructions in a race against time to save his family.",
        popularity = 1730.839,
        posterPath = "/oUmmY7QWWn7OhKlcPOnirHJpP1F.jpg",
        releaseDate = "2023-08-23",
        title = "Retribution",
        video = false,
        voteAverage = 6.8,
        voteCount = 230
    )

    val movie3 = Movie(
        adult = false,
        backdropPath = "/8pjWz2lt29KyVGoq1mXYu6Br7dE.jpg",
        genreIds = listOf(28, 878, 27),
        id = 615656,
        originalLanguage = "en",
        originalTitle = "Meg 2: The Trench",
        overview = "An exploratory dive into the deepest depths of the ocean of a daring research team spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival.",
        popularity = 1363.273,
        posterPath = "/4m1Au3YkjqsxF8iwQy0fPYSxE0h.jpg",
        releaseDate = "2023-08-02",
        title = "Meg 2: The Trench",
        video = false,
        voteAverage = 7.0,
        voteCount = 1959
    )

    val movie4 = Movie(
        adult = false,
        backdropPath = "/4XM8DUTQb3lhLemJC51Jx4a2EuA.jpg",
        genreIds = listOf(28, 80, 53),
        id = 385687,
        originalLanguage = "en",
        originalTitle = "Fast X",
        overview = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever.",
        popularity = 1264.755,
        posterPath = "/fiVW06jE7z9YnO4trhaMEdclSiC.jpg",
        releaseDate = "2023-05-17",
        title = "Fast X",
        video = false,
        voteAverage = 7.3,
        voteCount = 3852
    )

    val movie5 = Movie(
        adult = false,
        backdropPath = "/iIvQnZyzgx9TkbrOgcXx0p7aLIC.jpg",
        genreIds = listOf(27, 53),
        id = 1008042,
        originalLanguage = "en",
        originalTitle = "Talk to Me",
        overview = "When a group of friends discover how to conjure spirits using an embalmed hand, they become hooked on the new thrill, until one of them goes too far and unleashes terrifying supernatural forces.",
        popularity = 1207.188,
        posterPath = "/kdPMUMJzyYAc4roD52qavX0nLIC.jpg",
        releaseDate = "2023-07-26",
        title = "Talk to Me",
        video = false,
        voteAverage = 7.2,
        voteCount = 876
    )

    val movie6 = Movie(
        adult = false,
        backdropPath = "/ctMserH8g2SeOAnCw5gFjdQF8mo.jpg",
        genreIds = listOf(35, 12, 14),
        id = 346698,
        originalLanguage = "en",
        originalTitle = "Barbie",
        overview = "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
        popularity = 1315.19,
        posterPath = "/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
        releaseDate = "2023-07-19",
        title = "Barbie",
        video = false,
        voteAverage = 7.3,
        voteCount = 4990
    )

    val movie7 = Movie(
        adult = false,
        backdropPath = "/53z2fXEKfnNg2uSOPss2unPBGX1.jpg",
        genreIds = listOf(27, 9648, 53),
        id = 968051,
        originalLanguage = "en",
        originalTitle = "The Nun II",
        overview = "In 1956 France, a priest is violently murdered, and Sister Irene begins to investigate. She once again comes face-to-face with a powerful evil.",
        popularity = 1135.055,
        posterPath = "/5gzzkR7y3hnY8AD1wXjCnVlHba5.jpg",
        releaseDate = "2023-09-06",
        title = "The Nun II",
        video = false,
        voteAverage = 6.5,
        voteCount = 327
    )

    val movie8 = Movie(
        adult = false,
        backdropPath = "/4fLZUr1e65hKPPVw0R3PmKFKxj1.jpg",
        genreIds = listOf(16, 35, 10751, 14, 10749),
        id = 976573,
        originalLanguage = "en",
        originalTitle = "Elemental",
        overview = "In a city where fire, water, land, and air residents live together, a fiery young woman and a go-with-the-flow guy will discover something elemental: how much they have in common.",
        popularity = 721.589,
        posterPath = "/4Y1WNkd88JXmGfhtWR7dmDAo1T2.jpg",
        releaseDate = "2023-06-14",
        title = "Elemental",
        video = false,
        voteAverage = 7.8,
        voteCount = 2390
    )

    val movie9 = Movie(
        adult = false,
        backdropPath = "/5xUJBgds96m6Xi2EtUpSzbw24D7.jpg",
        genreIds = listOf(53, 9648),
        id = 852436,
        originalLanguage = "fr",
        originalTitle = "Seule : Les dossiers Silvercloud",
        overview = "Alone in the mountains of Switzerland, Anne discovers that her isolated chalet is on surveillance and has been bugged. Caught up by her former life as an intelligence secret agent and an affair with her handler, Anne can only count on herself to get out alive.",
        popularity = 831.039,
        posterPath = "/qx81rP4b4UFcxjabCqfe79F24Z0.jpg",
        releaseDate = "2023-03-08",
        title = "Let Her Kill You",
        video = false,
        voteAverage = 6.6,
        voteCount = 43
    )

    val movie10 = Movie(
        adult = false,
        backdropPath = "/iOJX54nVAsnPawagFiWXKv1Y6sB.jpg",
        genreIds = listOf(16, 12, 10751),
        id = 1076364,
        originalLanguage = "en",
        originalTitle = "Carl's Date",
        overview = "Carl Fredricksen reluctantly agrees to go on a date with a lady friend—but admittedly has no idea how dating works these days. Ever the helpful friend, Dug steps in to calm Carl's pre-date jitters and offer some tried-and-true tips for making friends—if you're a dog.",
        popularity = 696.244,
        posterPath = "/y8NtM6q3PzntqyNRNw6wgicwRYl.jpg",
        releaseDate = "2023-06-15",
        title = "Carl's Date",
        video = false,
        voteAverage = 7.8,
        voteCount = 180
    )


    return MovieResponse(
        page = 1,
        results = listOf(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10),
        totalPages = 40250,
        totalResults = 804998
    )
}