package video

data class VideoConfiguration(
    val height: Float,
    val width: Float,
    val duration: Int,
    val fps: Int = 24,
    val filename: String,
    val cadres: MutableList<Cadre>
)
