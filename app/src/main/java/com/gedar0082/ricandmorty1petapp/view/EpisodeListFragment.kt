package com.gedar0082.ricandmorty1petapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gedar0082.data.netclient.NetClient
import com.gedar0082.data.repoimpl.EpisodeRepoImpl
import com.gedar0082.domain.entities.Episode
import com.gedar0082.ricandmorty1petapp.databinding.FragmentEpisodeListBinding
import com.gedar0082.ricandmorty1petapp.view.adapter.EpisodeListAdapter
import com.gedar0082.ricandmorty1petapp.viewmodel.EpisodeListViewModel
import com.gedar0082.ricandmorty1petapp.viewmodel.factory.EpisodeListViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


private const val ARG_PARAM_PAGE = "page"

class EpisodeListFragment : Fragment() {


    private lateinit var navController: NavController
    private lateinit var vm: EpisodeListViewModel
    private val net = NetClient.net

    private var paramPage = 1 //default value

    private var _binding: FragmentEpisodeListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControllerInit()
        viewModelInit()
        parseInputArguments()
        vm.getAllEpisodes(paramPage)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingInit(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()

    }

    private fun navControllerInit() {
        navController = findNavController()
    }

    private fun viewModelInit() {
        val repo = EpisodeRepoImpl(net)
        val factory = EpisodeListViewModelFactory(repo)
        vm = ViewModelProvider(this, factory)
            .get(EpisodeListViewModel::class.java)
    }

    private fun parseInputArguments() {
        arguments?.let {
            paramPage = it.getInt(ARG_PARAM_PAGE)
        }
    }

    private fun bindingInit(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentEpisodeListBinding.inflate(inflater, container, false)
    }

    private fun setupRecycleView() {
        binding.episodeListRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            lifecycleScope.launchWhenCreated {
                vm.episodes.onEach {
                    adapter = getRecycleViewAdapter(it)
                }.collect()
            }
        }
    }

    private fun getRecycleViewAdapter(episodes: List<Episode>): EpisodeListAdapter {
        return EpisodeListAdapter(episodes) { episode ->
            Toast.makeText(context, episode.name, Toast.LENGTH_SHORT).show()
        }
    }

}