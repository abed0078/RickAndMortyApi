package com.example.rickandmorty.Network.response


import com.example.rickandmorty.GetCharacterByIdResponse

data class GetCharacterPageResponse(
    val info: Info = Info(),
    val result: List<GetCharacterByIdResponse>){



}
data class Info (
    val count:Int=0,
    val pages:Int=0,
    val next:String?=null,
    val prev:String?=null)

