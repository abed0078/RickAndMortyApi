package com.example.rickandmorty

import retrofit2.Response
import retrofit2.http.Path

class SharedRepository {
    suspend fun getCharacterById(characterId:Int): GetCharacterByIdResponse?{
         val request=NetworkLayer.apiClient.getCharacterById(characterId)

        if(request.isSuccessful){
            return request.body()!!
        }
        return null
    }

}
