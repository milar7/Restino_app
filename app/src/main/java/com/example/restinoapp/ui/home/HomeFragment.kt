package com.example.restinoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.restinoapp.R
import com.example.restinoapp.databinding.FragmentHomeBinding
import com.example.restinoapp.ui.home.slideshow.Slide
import com.example.restinoapp.ui.home.slideshow.SlideShowPagerAdapter
import java.util.*

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var slideAdapter: SlideShowPagerAdapter

    companion object {
        val slides = mutableListOf<Slide>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this
        setupSlideshow()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel


    }

    private fun setupSlideshow() {

        slides.add(Slide(R.drawable.slide1))
        slides.add(Slide(R.drawable.slide2))
        slides.add(Slide(R.drawable.slide3))
        slideAdapter = SlideShowPagerAdapter(this!!.context!!, slides)
        binding.vPager.adapter = slideAdapter
        binding.vPager.currentItem=0



        binding.tabIndicator.setupWithViewPager(binding.vPager, true)
        val timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(), 4000, 6000)
    }

    inner class SliderTimer : TimerTask() {
        override fun run() {

            activity?.runOnUiThread(object : Runnable {
                override fun run() {
                    if (binding.vPager.currentItem < HomeFragment.slides.size - 1) {
                        binding.vPager.currentItem = binding.vPager.currentItem + 1
                    } else {
                        binding.vPager.currentItem = 0
                    }
                }

            })
        }


    }

}

