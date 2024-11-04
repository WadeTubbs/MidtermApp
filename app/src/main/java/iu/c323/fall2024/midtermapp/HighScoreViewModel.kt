package iu.c323.fall2024.midtermapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HighScoreViewModel(application: Application) : AndroidViewModel(application) {
    private val highScoreDao = AppDatabase.getDatabase(application).highScoreDao()
    val allHighScores: LiveData<List<HighScoreEntity>> = highScoreDao.getAllHighScores()

    fun insert(highScore: HighScoreEntity) {
        viewModelScope.launch {
            highScoreDao.insertHighScore(highScore)
        }
    }

    fun delete(highScore: HighScoreEntity) {
        viewModelScope.launch {
            highScoreDao.deleteHighScore(highScore)
        }
    }
}
