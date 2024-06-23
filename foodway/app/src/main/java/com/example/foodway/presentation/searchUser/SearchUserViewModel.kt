
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodway.domain.searchUser.model.SearchedCustomer
import com.example.foodway.domain.searchUser.model.SearchedEstablishment
import com.example.foodway.domain.searchUser.usecase.GetCustomerUseCase
import com.example.foodway.domain.searchUser.usecase.GetEstablishmentUseCase
import com.example.foodway.domain.searchUser.usecase.PatchFavoriteUseCase
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.utils.PreferencesManager
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class SearchUserViewModel(
    private val getCustomerUseCase: GetCustomerUseCase,
//    private val getFavoriteUseCase: GetFavoriteUseCase,
    private val getEstablishmentUseCase: GetEstablishmentUseCase,
    private val patchFavoriteUseCase: PatchFavoriteUseCase,
    context: Context
) : ViewModel() {

    val customers = MutableLiveData<List<SearchedCustomer>>()
    val establishments = MutableLiveData<List<SearchedEstablishment>>()
    val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

    private val sharedPreferences = PreferencesManager(context)
    val filter = mutableStateOf("")

    fun updateFilter(newFilter: String) {
        filter.value = newFilter
    }

    fun getAllEstablishments(
        searchFilter: String? = "COMMENTS"
    ) {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("SearchUserViewModel", "Loading started")

                val response = getEstablishmentUseCase(
                    idSession = UUID.fromString(
                        sharedPreferences.getSavedData("id", ""),
                    ),
                    searchFilter = searchFilter!!
                )
                establishments.value = response
                state.value = MainScreenState.Success(data = response)

                Log.d("response antes do IF", response.toString())
            } catch (e: HttpException) {
                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Estabelecimentos não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SearchUserViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun getAllCustomers() {
        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                val response = getCustomerUseCase(
                    idSession = UUID.fromString(
                        sharedPreferences.getSavedData("id", "")
                    ),
                    token = sharedPreferences.getSavedData("token", "")
                )
                customers.value = response
                state.value = MainScreenState.Success(data = response)
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    404 -> "Clientes não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

//    fun getAllFavorites() {
//        viewModelScope.launch {
//            try {
//                state.value = MainScreenState.Loading
//                Log.d("SearchUserViewModel", "Loading started")
//                val response = getFavoriteUseCase(
//                    idSession = UUID.fromString(sharedPreferences.getSavedData("id", "")),
//                    idUser = UUID.fromString(sharedPreferences.getSavedData("id", "")),
//                    token = sharedPreferences.getSavedData("token", "")
//                )
//                favorites.value = response
//                state.value = MainScreenState.Success(data = response)
//            } catch (e: HttpException) {
//                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
//                val message = when (e.code()) {
//                    404 -> "Estabelecimentos não encontrados"
//                    400 -> "Requisição incorreta"
//                    else -> "Erro desconhecido"
//                }
//                state.value = MainScreenState.Error(message)
//            } catch (e: Exception) {
//                Log.e("SearchUserViewModel", "Exception: ${e.message}")
//                state.value = MainScreenState.Error(
//                    e.message ?: "Erro desconhecido"
//                )
//            }
//        }
//    }

    fun patchFavorite(
        idCustomer: UUID,
        idEstablishment: UUID
    ) {
        val state = MutableLiveData<MainScreenState>(MainScreenState.Loading)

        viewModelScope.launch {
            try {
                state.value = MainScreenState.Loading
                Log.d("ids", "$idEstablishment $idCustomer")

                if (sharedPreferences.getSavedData("typeUser", "") == "CLIENT") {
                    val response = patchFavoriteUseCase(
                        idCustomer = idCustomer,
                        idEstablishment = idEstablishment,
                        token = sharedPreferences.getSavedData("token", "")
                    )
                } else {
                    Log.d("search", "somente clientes podem favoritar")
                }

                Log.d("search", "favoritado")
            } catch (e: HttpException) {
                Log.e("SearchUserViewModel", "HTTP Exception: ${e.message()}")
                val message = when (e.code()) {
                    404 -> "Clientes não encontrados"
                    400 -> "Requisição incorreta"
                    else -> "Erro desconhecido"
                }
                state.value = MainScreenState.Error(message)
            } catch (e: Exception) {
                Log.e("SearchUserViewModel", "Exception: ${e.message}")
                state.value = MainScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }
}