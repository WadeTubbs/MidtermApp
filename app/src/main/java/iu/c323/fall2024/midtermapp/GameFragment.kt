package iu.c323.fall2024.midtermapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameFragment : Fragment() {

    private lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        database = AppDatabase.getDatabase(requireContext()) // Initialize the database
        return view
    }

    private fun insertHighScore(playerName: String, score: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val highScore = HighScoreEntity(playerName = playerName, score = score)
            database.highScoreDao().insertHighScore(highScore)
        }
    }

    private fun onGameCompleted(playerName: String, score: Int) {
        insertHighScore(playerName, score)
        requireActivity().runOnUiThread {
            Toast.makeText(requireContext(), "Score saved!", Toast.LENGTH_SHORT).show()
        }
    }
}
