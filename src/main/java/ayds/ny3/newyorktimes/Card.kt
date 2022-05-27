package ayds.ny3.newyorktimes


interface Card {
    val description: String
    val infoURL: String
    val source: String
    var sourceLogoUrl: String
}

data class NytCard(
    override val description: String,
    override val infoURL: String,
    override val source: String,
    override var sourceLogoUrl: String
) : Card