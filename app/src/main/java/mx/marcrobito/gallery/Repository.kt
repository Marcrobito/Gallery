package mx.marcrobito.gallery

interface Repository {
    suspend fun getHitsList(image:String):List<Hit>
    //suspend fun getHitByID(id:Int):Hit
}