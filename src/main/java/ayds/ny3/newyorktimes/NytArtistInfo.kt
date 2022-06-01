package ayds.ny3.newyorktimes

data class NytArtistInfo(
    val artistName: String,
    val artistInfo: String,
    val artistURL: String,
    val nytLogo: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"
)