package mx.marcrobito.gallery

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("?key=16319352-2bb88398aa817f97a71677f6d&image_type=photo")
    suspend fun getImagesForString(@Query("q") image:String ):ImageResponse
}

/*

 */