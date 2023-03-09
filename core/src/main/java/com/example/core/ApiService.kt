import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET
    fun login(username: String, password: String): Call<Unit>
}
