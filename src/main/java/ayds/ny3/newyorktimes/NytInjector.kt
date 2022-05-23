package ayds.ny3.newyorktimes

import ayds.ny3.newyorktimes.article.JsonToArtistInfoResolver
import ayds.ny3.newyorktimes.article.NytArticleServiceImpl

object NytInjector {

    val nytArticleService: NytArticleService = NytArticleServiceImpl(JsonToArtistInfoResolver())
}