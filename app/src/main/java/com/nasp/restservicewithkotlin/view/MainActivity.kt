package com.nasp.restservicewithkotlin.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasp.restservicewithkotlin.databinding.ActivityMainBinding
import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import com.nasp.restservicewithkotlin.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterA: ApiAdapter
    private var progressBar: ProgressBarDialog? = null

    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.listUsers()
        presenter.listPost()
        progressBar = ProgressBarDialog(this)
        progressBar?.show()

    }

    override fun showResult(result: ArrayList<UserDataCollectionItem> ) {
        Log.d("Success Response", result.toString())
        progressBar?.dismiss()

        search.visibility= View.VISIBLE
        recyclerview.visibility = View.VISIBLE
        showData(result)
    }

    override fun errorResult(t: String) {
        Log.d("Success Response", t)

    }

    override fun showResult2(result: ArrayList<PostDataCollectionItem> ) {
        Log.d("Success Response", result.toString())

    }

    override fun errorResult2(t: String) {
        Log.d("Success Response", t)
    }

    private fun showData(users: ArrayList<UserDataCollectionItem>) {
        adapterA = ApiAdapter(users)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapterA
    }
}