package com.example.beachsearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beachsearch.adapter.BeachAdapter
import com.example.beachsearch.model.BeachModel
import com.example.beachsearch.ui.theme.BeachSearchTheme

class MainActivity : ComponentActivity() {
    private lateinit var beachAdapter: BeachAdapter
    private val beachList = mutableListOf<BeachModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val editNomePraia = findViewById<EditText>(R.id.editNomePraia)
        val editCidade = findViewById<EditText>(R.id.editCidade)
        val editEstado = findViewById<EditText>(R.id.editEstado)
        val btnIncluir = findViewById<Button>(R.id.btnIncluir)

        beachAdapter = BeachAdapter(beachList) { beach ->
            beachList.remove(beach)
            beachAdapter.notifyDataSetChanged()
        }
        recyclerView.adapter = beachAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnIncluir.setOnClickListener {
            val nome = editNomePraia.text.toString()
            val cidade = editCidade.text.toString()
            val estado = editEstado.text.toString()

            if (nome.isNotBlank() && cidade.isNotBlank() && estado.isNotBlank()) {
                val beach = BeachModel(nome, cidade, estado)
                beachList.add(beach)
                beachAdapter.notifyDataSetChanged()

                editNomePraia.text.clear()
                editCidade.text.clear()
                editEstado.text.clear()


        setContent {
        }
    }
}
    }
}