package com.example.photoalbum.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoalbum.R
import com.example.photoalbum.adapter.MyImagesAdapter
import com.example.photoalbum.databinding.ActivityMainBinding
import com.example.photoalbum.viewmodel.MyImagesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var myImagesViewModel: MyImagesViewModel
    private lateinit var mainBinding : ActivityMainBinding
    lateinit var myImagesAdapter: MyImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // Инициализация ViewModel
        myImagesViewModel = ViewModelProvider(this)[MyImagesViewModel::class.java]

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        myImagesAdapter = MyImagesAdapter(this)
        mainBinding.recyclerView.adapter = myImagesAdapter

        // Наблюдение за изменениями данных в ViewModel
        myImagesViewModel.getAllImages().observe(this, Observer { images->
            //update UI
            myImagesAdapter.setImage(images)

        })

        // Обработчик нажатия на плавающую кнопку
        mainBinding.floatingActionButton.setOnClickListener {
            //open AddImageActivity
            val intent = Intent(this,AddImageActivity::class.java)
            startActivity(intent)

        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //dialog message or snackbar message
                myImagesViewModel.delete(myImagesAdapter.returnItemAtGivenPosition(viewHolder.adapterPosition))
            }

        }).attachToRecyclerView(mainBinding.recyclerView)

    }
}