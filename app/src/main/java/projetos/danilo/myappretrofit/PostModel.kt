package projetos.danilo.myappretrofit

import com.google.gson.annotations.SerializedName

class PostModel {

    //@SerializedName biblioteca Gson, para pegar o atributo da API quando nome diferente
    @SerializedName("id")
    var id: Int = 0
    var userId: Int = 0
    var title: String = ""
    var body: String = ""
}