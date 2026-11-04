package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(
                this@MainActivity,
                "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT
            ).show()
        }

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                // layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural", imageDisaster = R.drawable.img_tsunami),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural", imageDisaster = R.drawable.img_volcanic_eruption),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural", imageDisaster = R.drawable.img_earthquake),
            Disaster(nameDisaster = "Flood", disasterType = "Natural", imageDisaster = R.drawable.img_flood),
            Disaster(nameDisaster = "Fire", disasterType = "Natural", imageDisaster = R.drawable.img_fire),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made", imageDisaster = R.drawable.img_nuclear_accident),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made", imageDisaster = R.drawable.img_terrorist_attack),
            Disaster(nameDisaster = "War", disasterType = "Man-made", imageDisaster = R.drawable.img_war)
        )
    }
}
