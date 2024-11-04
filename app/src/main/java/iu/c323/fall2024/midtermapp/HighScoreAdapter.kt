package iu.c323.fall2024.midtermapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class HighScoreAdapter :
    ListAdapter<HighScoreEntity, HighScoreAdapter.HighScoreViewHolder>(HighScoreDiffCallback()) {

    class HighScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerNameTextView: TextView = itemView.findViewById(R.id.text_player_name)
        val scoreTextView: TextView = itemView.findViewById(R.id.text_score)

        fun bind(highScore: HighScoreEntity) {
            playerNameTextView.text = highScore.playerName
            scoreTextView.text = highScore.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighScoreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_high_score, parent, false)
        return HighScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighScoreViewHolder, position: Int) {
        val highScore = getItem(position)
        holder.bind(highScore)
    }
}

class HighScoreDiffCallback : DiffUtil.ItemCallback<HighScoreEntity>() {
    override fun areItemsTheSame(oldItem: HighScoreEntity, newItem: HighScoreEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HighScoreEntity, newItem: HighScoreEntity): Boolean {
        return oldItem == newItem
    }
}
