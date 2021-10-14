package com.nasp.restservicewithkotlin.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasp.restservicewithkotlin.adapter.ApiAdapter
import com.nasp.restservicewithkotlin.databinding.ActivityMainBinding
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import com.nasp.restservicewithkotlin.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView, ApiAdapter.itemClickListener{

    private lateinit var binding: ActivityMainBinding
    private var progressBar: ProgressBarDialog? = null

    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.listUsers()
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
        Log.d("Error", t)

    }

    private fun showData(users: ArrayList<UserDataCollectionItem>) {
        recyclerview.adapter = ApiAdapter(this,users)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(name: String, phone: String, email: String) {

        val intent = Intent(this,ActivityPosts::class.java)
        intent.putExtra("name",name)
        intent.putExtra("phone",phone)
        intent.putExtra("email",email)
        startActivity(intent)
    }
}