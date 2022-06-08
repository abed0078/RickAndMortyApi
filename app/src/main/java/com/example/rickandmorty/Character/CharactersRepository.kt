package com.example.rickandmorty.Character

import com.example.rickandmorty.Network.NetworkLayer
import com.example.rickandmorty.Network.response.GetCharacterPageResponse

class CharactersRepository {
    suspend fun getCharactersPage(pageIndex:Int): GetCharacterPageResponse?{
      val request=NetworkLayer.apiClient.getCharactersPage(pageIndex)
        if(request.failed||!request.isSuccessful){
            return null

        }
        return request.body
    }

}
