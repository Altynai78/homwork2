package com.example.homwork2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundzzzz.
import com.example.homwork2.mod.Photo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val list: ArrayList<Photo> = ArrayList()

    private var selectedList: ArrayList<Photo> = ArrayList()

    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        initAdapter()
        initListener()

    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this,SelectedActivity::class.java)
            intent.putExtra(MA_SA, selectedList)
            startActivity(intent)
        }
    }

    private fun initAdapter() {
        adapter = ImageAdapter(list, this::clickListener, this::deleteItem)
        binding.recycler.adapter = adapter
    }

    private fun clickListener(item: Photo) {
        selectedList.add(item)
    }

    private fun deleteItem(item: Photo) {
        selectedList.remove(item)
    }


    private fun loadImage() {
        list.add(Photo("https://nashzelenyimir.ru/wp-content/uploads/2016/08/%D0%9E%D0%B2%D1%86%D0%B0-%D0%B4%D0%BE%D0%BC%D0%B0%D1%88%D0%BD%D1%8F%D1%8F-%D0%BB%D0%B0%D1%82.-Ovis-aries.jpg"))
        list.add(Photo("https://skmvl.ru/static/images/news/None/1626821876_60-krasivosti-pro-p-barani-myasnoi-porodi-samie-bolshie-zhivot-65.jpg"))
        list.add(Photo("https://skmvl.ru/static/images/news/None/1626821876_60-krasivosti-pro-p-barani-myasnoi-porodi-samie-bolshie-zhivot-65.jpg"))
        list.add(Photo("https://boardpoint.ru/upload/iblock/9a0/zipf55yfa1w11bphog9uxt15l8aksj98.jpg"))
        list.add(Photo("https://klike.net/uploads/posts/2023-01/1674709841_7-4.jpg"))
        list.add(Photo("https://krasivosti.pro/uploads/posts/2022-09/1663062339_8-krasivosti-pro-p-ushi-barana-zhivotnie-23.jpg"))
        list.add(Photo("https://i.pinimg.com/originals/79/46/bb/7946bbaff0904c56e10775e7facf004e.jpg"))
        list.add(Photo("https://klike.net/uploads/posts/2023-01/1674709767_2-3.jpg"))
        list.add(Photo("https://klike.net/uploads/posts/2023-01/1674709784_3-67.jpg"))
        list.add(Photo("https://klike.net/uploads/posts/2023-01/1674709791_3-74.jpg"))
        list.add(Photo("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzjA_YG33uyScH5ViKB-N5qaKTM5SRkZCeTgDn6uOyic"))
        list.add(Photo("https://i.pinimg.com/originals/b7/b0/77/b7b0774acefbd0f9ed14badd81c63895.jpg"))
        list.add(Photo("https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663282133_10-mykaleidoscope-ru-p-zloi-baran-vkontakte-10.jpg"))
        list.add(Photo("https://klike.net/uploads/posts/2023-01/1674709842_7-3.jpg"))
        list.add(Photo("https://oir.mobi/uploads/posts/2021-05/1621048762_22-oir_mobi-p-morda-barana-zhivotnie-krasivo-foto-22.jpg"))
    }
    companion object{
        const val MA_SA = "MA_SA"
    }
}