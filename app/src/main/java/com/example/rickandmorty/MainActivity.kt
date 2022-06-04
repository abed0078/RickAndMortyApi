package com.example.rickandmorty

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
val moshi= Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val rickAndMortyService:RickAndMortyService = retrofit.create(RickAndMortyService::class.java)
        rickAndMortyService.getCharacerById().enqueue(object:Callback<GetCharacterByIdResponse>{
            override fun onResponse(call: Call<GetCharacterByIdResponse>, response: Response<GetCharacterByIdResponse>) {
                Log.i(TAG,response.toString())
                if(!response.isSuccessful){
                    Toast.makeText(this@MainActivity, "unsuccessful network call", Toast.LENGTH_SHORT).show()
                        return
                }
                val body=response.body()!!
             binding.textView.text=body.name
                binding.textStatus.text=body.status
                binding.textLocation.text=body.location.name
                binding.textHuman.text=body.species
                if(body.gender.equals("male",true)){
                    binding.imageGender.setImageResource(R.drawable.ic_gender_male)
                }else{
                    binding.imageGender.setImageResource(R.drawable.ic_gender_female)

                }
                Picasso.get().load(body.image).into(binding.imageView);



            }

            override fun onFailure(call: Call<GetCharacterByIdResponse>, t: Throwable) {
                Log.i(TAG,t.message?:"Null Message")
            }

        })
    }
}