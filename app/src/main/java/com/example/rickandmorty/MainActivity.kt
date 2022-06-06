package com.example.rickandmorty

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    private val epoxyController=CharacterDetailsEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


viewModel.refreshCharacter(54)
        viewModel.characterByIdLiveData.observe(this) { response ->
            epoxyController.characterResponse=response
            if (response == null) {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()

                return@observe
            }
        }
        viewModel.refreshCharacter(54)
        val epoxyRecyclerView=findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView)
        epoxyRecyclerView.setControllerAndBuildModels(epoxyController)

    }


}