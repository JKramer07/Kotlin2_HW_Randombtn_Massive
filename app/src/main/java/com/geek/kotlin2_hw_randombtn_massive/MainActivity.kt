package com.geek.kotlin2_hw_randombtn_massive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geek.kotlin2_hw_randombtn_massive.databinding.ActivityMainBinding
import com.geek.kotlin2_hw_randombtn_massive.extensions.loadImage
import com.geek.kotlin2_hw_randombtn_massive.extensions.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private var mutableImages = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        getImages()
        setupSubmit()
        setupRandom()

    }

    private fun getImages() {
        mutableImages.add(getString(R.string.url_1))
        mutableImages.add(getString(R.string.url_2))
        mutableImages.add(getString(R.string.url_3))
        mutableImages.add(getString(R.string.url_4))
        mutableImages.add(getString(R.string.url_5))
    }

    private fun setupRandom() {
        viewBinding.btnRandom.setOnClickListener {
            viewBinding.ivImage.loadImage(mutableImages.random())
        }
    }

    private fun setupSubmit() {
        viewBinding.btnSubmit.setOnClickListener {
            mutableImages.add(viewBinding.etText.text.toString())
            viewBinding.etText.setText("")
            showToast(getString(R.string.toast_added))
        }
    }
}