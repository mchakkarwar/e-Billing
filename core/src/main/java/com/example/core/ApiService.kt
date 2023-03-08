import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET
    fun login(username: String, password: String): Flow<Boolean>
}
