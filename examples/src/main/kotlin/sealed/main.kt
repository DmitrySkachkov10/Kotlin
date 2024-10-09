package sealed


sealed class ApiResponse {
    data class Success(val result: String) : ApiResponse()
    data class Error(val result: String) : ApiResponse()
    object Loading : ApiResponse() {
        const val process: String = "Loading..."
    }

}

fun handleResponse(response: ApiResponse) {
    when (response) {
        is ApiResponse.Error -> println("OMG it's an Error ${response.result}")
        is ApiResponse.Success -> println("OK ${response.result}")
        is ApiResponse.Loading -> println(ApiResponse.Loading.process)
    }
}

fun main() {
    handleResponse(ApiResponse.Loading)
    handleResponse(ApiResponse.Success("nice!!"))
    handleResponse(ApiResponse.Error("So bad"))
}

