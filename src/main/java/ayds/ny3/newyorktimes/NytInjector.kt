package ayds.ny3.newyorktimes

import ayds.ny3.newyorktimes.article.JsonToArtistInfoResolver
import ayds.ny3.newyorktimes.article.NYTimesAPI
import ayds.ny3.newyorktimes.article.NytArticleServiceImpl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val NYT_API_URL = "https://api.nytimes.com/svc/search/v2/"

object NytInjector {

    private val nyTimesAPI: NYTimesAPI = createRetrofit()

    private fun createRetrofit(): NYTimesAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(NYT_API_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        return retrofit.create(NYTimesAPI::class.java)
    }

    val nytArticleService: NytArticleService = NytArticleServiceImpl(
        JsonToArtistInfoResolver(),
        nyTimesAPI
    )
}