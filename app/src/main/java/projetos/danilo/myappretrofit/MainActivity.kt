package projetos.danilo.myappretrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var postsDoBlog: MutableList<PostModel>? = arrayListOf()
    var myString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrofitClient.createService((PostService::class.java))
        val call: Call<List<PostModel>> = remote.list()

        /** Chama assíncrona ENQUEUE igual á ENFILEIRAR */
        val response = call.enqueue(object : Callback<List<PostModel>>{
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<PostModel>>, resp: Response<List<PostModel>>
            ) {
                val s = resp.body()

                if (s != null) {
                    for(item in s) {
                        if(item.id == 12){
                            text_example.text =
                                "id: ${item.id} - título: ${item.title}\n${item.body}"
                        }
                    }
                }
            }

        })

    }
}
