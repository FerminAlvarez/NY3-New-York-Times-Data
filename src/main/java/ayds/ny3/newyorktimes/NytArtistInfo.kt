package ayds.ny3.newyorktimes


interface ArtistInfo {
    val artistName: String
    val artistInfo: String
    val artistURL: String
    var isLocallyStored: Boolean
}

data class NytArtistInfo(
    override val artistName: String,
    override val artistInfo: String,
    override val artistURL: String,
    override var isLocallyStored: Boolean = false
) : ArtistInfo