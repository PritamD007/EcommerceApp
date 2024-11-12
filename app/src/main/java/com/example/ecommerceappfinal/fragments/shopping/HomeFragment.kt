package com.example.ecommerceappfinal.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceappfinal.R
import com.example.ecommerceappfinal.adapters.HomeViewPagerAdapter
import com.example.ecommerceappfinal.databinding.FragmentHomeBinding
import com.example.ecommerceappfinal.fragments.categories.AccessoriesFragment
import com.example.ecommerceappfinal.fragments.categories.KidsFragment
import com.example.ecommerceappfinal.fragments.categories.LatestTrendsFragment
import com.example.ecommerceappfinal.fragments.categories.MainCategoryFragment
import com.example.ecommerceappfinal.fragments.categories.MenFragment
import com.example.ecommerceappfinal.fragments.categories.WomenFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home){
        private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            WomenFragment(),
            MenFragment(),
            KidsFragment(),
            AccessoriesFragment(),
            LatestTrendsFragment()


        )

        val viewPager2Adapter = HomeViewPagerAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewPagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPagerHome){tab, position ->
            when(position){
                0 -> tab.text = "Home"
                1 -> tab.text = "Women"
                2 -> tab.text = "Men"
                3 -> tab.text = "Kids"
                4 -> tab.text = "Accessories"
                5 -> tab.text = "Latest\nTrends"
            }
        }.attach()
    }
}