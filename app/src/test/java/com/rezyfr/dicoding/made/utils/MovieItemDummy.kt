package com.rezyfr.dicoding.made.utils

import com.rezyfr.dicoding.core.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.core.data.source.remote.response.MovieResponse

object MovieItemDummy {
    fun getMovieListResponse(): List<MovieResponse> {
        return listOf(
            MovieResponse(
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "en",
                "Godzilla vs. Kong",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg", "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                "2021-03-24",
                8.3,
                399566,
                4450
            ), MovieResponse(
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "en", "Zack Snyder's Justice League", "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                8.5, 791373, 4910
            ),
            MovieResponse(
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "en", "Chaos Walking", "/5NxjLfs7Bi07bfZCRl9CCnUw7AA.jpg",
                "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "2021-02-24",
                7.5, 412656, 358
            )
        )
    }

    fun getMovieDetail(): MovieDetailResponse {
        return MovieDetailResponse(
            "en",
            "Zack Snyder's Justice League", "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
            791373, 4910,
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            242, "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "2021-03-18",
        )
    }
}