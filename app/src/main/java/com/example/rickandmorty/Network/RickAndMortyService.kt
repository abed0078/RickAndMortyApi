package com.example.rickandmorty.Network


import com.example.rickandmorty.GetCharacterByIdResponse
import com.example.rickandmorty.Network.response.GetCharacterPageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character/{character-id}")
   suspend fun getCharacterById(@Path("character-id")characterId:Int): Response<GetCharacterByIdResponse>

   @GET("character")
   suspend fun getCharactersPage(@Query("page")pageIndex:Int):Response<GetCharacterPageResponse>
}