package com.example.homwork2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homwork2.MainActivity.Companion.MA_SA
import com.example.homwork2.mod.Photo

class SelectedActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding

    private lateinit var adapter: ImageAdapter

    private var list: ArrayList<Photo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initGetExtra()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initGetExtra() {
        val getExtra = intent.getSerializableExtra(MA_SA) as? ArrayList<Photo>
        if (getExtra != null){
            list.addAll(getExtra)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter() {
        adapter = ImageAdapter(list, clickListener = {}, deleteItem = {})
        binding.recycler.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBackPressed() {
        super.onBackPressed()
        list.clear()
        adapter.notifyDataSetChanged()
        finish()
    }
 {
