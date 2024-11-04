package iu.c323.fall2024.midtermapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HighScoreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HighScoreAdapter
    private lateinit var viewModel: HighScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_high_score, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_high_scores)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the adapter
        adapter = HighScoreAdapter()
        recyclerView.adapter = adapter

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[HighScoreViewModel::class.java]

        // Observe the LiveData
        viewModel.allHighScores.observe(viewLifecycleOwner) { highScores ->
            adapter.submitList(highScores)
        }

        return view
    }
}
