package com.example.rickandmorty.Character

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmorty.databinding.ActivityCharacterListBinding


class CharacterListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCharacterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        val view = binding.root


    }
}