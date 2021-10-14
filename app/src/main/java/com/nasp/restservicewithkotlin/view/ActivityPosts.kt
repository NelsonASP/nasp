package com.nasp.restservicewithkotlin.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasp.restservicewithkotlin.adapter.ApiAdapterPos
import com.nasp.restservicewithkotlin.databinding.ActivityPostsBinding
import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.presenter.MainPresenterPos
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_posts.*
import javax.inject.Inject

@AndroidEntryPoint
class ActivityPosts : AppCompatActivity(), MainViewPos {

    private lateinit var binding: ActivityPostsBinding
    private var progressBar: ProgressBarDialog? = null

    @Inject
    lateinit var presenter: MainPresenterPos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityPostsBinding.inflate(layoutInflater)
         setContentView(binding.root)

         presenter.listPosts()

         progressBar = ProgressBarDialog(this)
         progressBar?.show()

         if(intent.extras != null){
            binding.tvNamePos.setText(intent.getStringExtra("name"))
            binding.tvPhonePos.setText(intent.getStringExtra("phone"))
            binding.tvEmailPos.setText(intent.getStringExtra("email"))

         }

    }

    override fun showResult(result: ArrayList<PostDataCollectionItem>) {
        Log.d("Success Response", result.toString())
        progressBar?.dismiss()

        contentUserInfo.visibility = View.VISIBLE
        recyclerViewPostsResults.visibility = View.VISIBLE
        panel.visibility = View.VISIBLE
        showData(result)
    }

    override fun errorResult(t: String) {
        Log.d("Error", t)
    }

    private fun showData(users: ArrayList<PostDataCollectionItem>) {
        binding.recyclerViewPostsResults.adapter = ApiAdapterPos(users)
        binding.recyclerViewPostsResults.setHasFixedSize(true)
        binding.recyclerViewPostsResults.layoutManager = LinearLayoutManager(this)
    }

}