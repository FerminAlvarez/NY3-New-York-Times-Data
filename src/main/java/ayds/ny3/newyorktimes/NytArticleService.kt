package ayds.ny3.newyorktimes


interface NytArticleService {
    fun getArtistInfo(name: String): Card?
}