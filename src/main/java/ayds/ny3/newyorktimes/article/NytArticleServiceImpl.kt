package ayds.ny3.newyorktimes.article

import ayds.ny3.newyorktimes.NytArticleService
import ayds.ny3.newyorktimes.NytArtistInfo
import retrofit2.Response

internal class NytArticleServiceImpl(
    private val nytToArtistInfoResolver: NytToArtistInfoResolver,
    private val nyTimesAPI: NYTimesAPI
) : NytArticleService {

    override fun getArtistInfo(name: String): NytArtistInfo? {
        val callResponse = getArtistInfoFromService(name)
        return nytToArtistInfoResolver.getArtistInfoFromExternalData(callResponse.body(), name)
    }

    private fun getArtistInfoFromService(query: String): Response<String?> {
        val response = nyTimesAPI.getArtistInfo(query)
        return response?.execute() ?: throw Exception("No Response from api")
    }
}