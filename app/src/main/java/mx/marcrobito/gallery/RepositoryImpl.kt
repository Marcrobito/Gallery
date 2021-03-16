package mx.marcrobito.gallery

class RepositoryImpl:Repository {

    private val service = Network.service

    override suspend fun getHitsList(image:String): List<Hit> {
        return service.getImagesForString(image).hits
    }

    /*override suspend fun getHitByID(id: Int): Hit {
        TODO("Not yet implemented")
    }*/
}