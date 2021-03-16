package mx.marcrobito.gallery

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse (
    @Json(name = "total")
    val totalResults:Int,
    @Json(name = "totalHits")
    val totalHits:Int,
    @Json(name = "hits")
    val hits:List<Hit>
)

@JsonClass(generateAdapter = true)
data class Hit (
    @Json(name = "id")
    val id:Int,
    @Json(name = "pageURL")
    val pageURL:String,
    @Json(name = "type")
    val type:String,
    @Json(name = "tags")
    val tags:String,
    @Json(name = "previewURL")
    val previewURL:String,
    @Json(name = "previewWidth")
    val previewWidth:Int,
    @Json(name = "previewHeight")
    val previewHeight:Int,
    @Json(name = "user")
    val user:String,
    @Json(name = "largeImageURL")
    val largeImageURL:String
    )
