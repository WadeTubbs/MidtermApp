package iu.c323.fall2024.midtermapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HighScoreDao {

    @Insert
    suspend fun insertHighScore(highScore: HighScoreEntity): Long // Corrected to return the ID of the inserted row

    @Delete
    suspend fun deleteHighScore(highScore: HighScoreEntity): Int // Corrected to return the number of rows affected

    @Query("SELECT * FROM high_scores ORDER BY score DESC")
    suspend fun getAllHighScores(): List<HighScoreEntity> // Corrected to return a List of HighScoreEntity
}
