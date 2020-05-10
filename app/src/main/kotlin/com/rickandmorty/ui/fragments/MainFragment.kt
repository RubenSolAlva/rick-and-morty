package com.rickandmorty.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.R
import com.rickandmorty.common.BaseFragment
import com.rickandmorty.common.Status
import com.rickandmorty.models.UICharacter
import com.rickandmorty.ui.adapters.CharacterAdapter
import com.rickandmorty.ui.viewmodels.MainViewModel
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


class MainFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel
    private var rootView: View? = null
    private var rvCharacters: RecyclerView? = null
    private var adapter: CharacterAdapter? = null
    private var pbCharacters: ProgressBar? = null
    companion object {
        val TAG: String = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false)

            rvCharacters = rootView?.findViewById(R.id.rvCharacters)
            pbCharacters = rootView?.findViewById(R.id.pbCharacters)

            bindViewModel()
            setUpUI()
            setupObservers()
        }
        return rootView
    }



    private fun bindViewModel() {
        activity?.let {
            viewModel =
                ViewModelProviders
                    .of(it, viewModelFactory)
                    .get(MainViewModel::class.java)
        }
    }

    private fun setUpUI() {
        rvCharacters?.layoutManager = LinearLayoutManager(context)
        adapter = CharacterAdapter(arrayListOf())
        rvCharacters?.adapter = adapter

    }

    private fun setupObservers() {
        viewModel.getCharacters().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        pbCharacters?.visibility = View.GONE
                        resource.data?.let { characters -> retrieveList(characters) }
                    }
                    Status.ERROR -> {
                        pbCharacters?.visibility = View.GONE
                        toast(it.message.toString())
                    }
                    Status.LOADING -> {
                        pbCharacters?.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(characters: List<UICharacter>) {
        adapter?.apply {
            addCharacters(characters)
            notifyDataSetChanged()
        }
    }
}