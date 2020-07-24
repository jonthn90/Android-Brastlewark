package xyz.jonthn.brastlewark.data.server

import retrofit2.http.GET

interface APIService {
    @GET("/rrafols/mobile_test/master/data.json")
    suspend fun getInhabitants(): APIResponse
}