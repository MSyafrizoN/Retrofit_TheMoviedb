package com.themoviedb.adaptors

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themoviedb.MovieFrag
import com.themoviedb.TvFrag

class ViewPageAdaptor(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment= Fragment()
        when (position){
            0 -> fragment = MovieFrag()
            1 -> fragment = TvFrag()
        }
        return fragment
    }
}