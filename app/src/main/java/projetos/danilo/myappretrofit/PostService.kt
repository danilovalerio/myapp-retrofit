package projetos.danilo.myappretrofit

import retrofit2.Call
import retrofit2.http.GET

/** recurso Post */
interface PostService {

    @GET("posts")
    fun list(): Call<List<PostModel>>

}