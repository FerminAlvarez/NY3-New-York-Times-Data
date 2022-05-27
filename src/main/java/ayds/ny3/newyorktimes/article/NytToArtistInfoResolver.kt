package ayds.ny3.newyorktimes.article

import ayds.ny3.newyorktimes.NytCard
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

interface NytToArtistInfoResolver {
    fun getArtistInfoFromExternalData(serviceData: String?): NytCard?
}

private const val SECTION_DOCS = "docs"
private const val SECTION_ABSTRACT = "abstract"
private const val SECTION_WEB_URL = "web_url"
private const val RESPONSE = "response"
private const val NYT_LOGO_URL =
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"
private const val SOURCE_NYT = "The New York Times"

internal class JsonToArtistInfoResolver : NytToArtistInfoResolver {

    override fun getArtistInfoFromExternalData(serviceData: String?): NytCard? {
        val result =
            try {
                serviceData?.getFirstItem()?.let { item ->
                    NytCard(
                        item.getArtistInfo(),
                        item.getArtistUrl(),
                        SOURCE_NYT,
                        NYT_LOGO_URL
                    )
                }
            } catch (e: Exception) {
                null
            }
        return result
    }

    private fun String?.getFirstItem(): JsonElement {
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        val response = jobj[RESPONSE].asJsonObject
        return response[SECTION_DOCS].asJsonArray[0]
    }

    private fun JsonElement.getArtistInfo() =
        abstractToString(this.asJsonObject[SECTION_ABSTRACT])

    private fun JsonElement.getArtistUrl() =
        this.asJsonObject[SECTION_WEB_URL].asString

    private fun abstractToString(abstractNYT: JsonElement?): String =
        abstractNYT?.let { it.asString.replace("\\n", "\n") } ?: ""

}