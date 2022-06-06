package com.example.rickandmorty

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.NetworkLayer.rickAndMortyService
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


viewModel.refreshCharacter(54)
        viewModel.characterByIdLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()

                return@observe
            }
            binding.textView.text = response.name
            binding.textStatus.text = response.status
            binding.textLocation.text = response.location.name
            binding.textHuman.text = response.species
            if (response.gender.equals("male", true)) {
                binding.imageGender.setImageResource(R.drawable.ic_gender_male)
            } else {
                binding.imageGender.setImageResource(R.drawable.ic_gender_female)

            }
            Picasso.get().load(response.image).into(binding.imageView);
        }

    }


}