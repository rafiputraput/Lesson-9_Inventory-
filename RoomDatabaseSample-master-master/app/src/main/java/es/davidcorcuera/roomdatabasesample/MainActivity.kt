package es.davidcorcuera.roomdatabasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.davidcorcuera.roomdatabasesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }

}