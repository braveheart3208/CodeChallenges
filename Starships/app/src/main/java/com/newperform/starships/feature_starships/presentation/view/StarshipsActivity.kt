package com.newperform.starships.feature_starships.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.newperform.starships.databinding.ActivityStarshipsBinding
import com.newperform.starships.feature_starships.domain.model.Starship
import com.newperform.starships.feature_starships.presentation.presenter.StarshipsPresenter
import com.newperform.starships.feature_starships.presentation.view.adapter.StarshipAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StarshipsActivity : AppCompatActivity(), StarshipsPresenter.StarshipView{

    @Inject
    lateinit var presenter : StarshipsPresenter

    private lateinit var binding : ActivityStarshipsBinding

    private val starshipAdapter = StarshipAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarshipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Setup RecyclerView
        binding.starshipsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@StarshipsActivity, LinearLayoutManager.VERTICAL, false)
            adapter = starshipAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.initView(this)
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingBar.visibility = View.GONE
    }

    override fun renderStarships(starships: List<Starship>) {
        starshipAdapter.setStarships(starships)
    }
}