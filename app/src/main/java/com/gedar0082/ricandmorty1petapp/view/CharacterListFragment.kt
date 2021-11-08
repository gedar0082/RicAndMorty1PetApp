package com.gedar0082.ricandmorty1petapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gedar0082.data.netclient.NetClient
import com.gedar0082.data.repoimpl.CharacterRepoImpl
import com.gedar0082.domain.entities.Character
import com.gedar0082.ricandmorty1petapp.R
import com.gedar0082.ricandmorty1petapp.databinding.FragmentCharacterListBinding
import com.gedar0082.ricandmorty1petapp.view.adapter.CharacterListAdapter
import com.gedar0082.ricandmorty1petapp.viewmodel.CharacterListViewModel
import com.gedar0082.ricandmorty1petapp.viewmodel.factory.CharacterListViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

private const val ARG_PARAM_PAGE = "page"

class CharacterListFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var vm: CharacterListViewModel
    private val net = NetClient.net

    private var paramPage = 1 //default value

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControllerInit()
        viewModelInit()
        parseInputArguments()
        vm.getAllCharacters(paramPage)
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
        val repo = CharacterRepoImpl(net)
        val factory = CharacterListViewModelFactory(repo)
        vm = ViewModelProvider(this, factory)
            .get(CharacterListViewModel::class.java)
    }

    private fun parseInputArguments(){
        arguments?.let {
            paramPage = it.getInt(ARG_PARAM_PAGE)
        }
    }

    private fun bindingInit(inflater: LayoutInflater, container: ViewGroup?){
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
    }

    private fun setupRecycleView(){
        binding.characterListRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            lifecycleScope.launchWhenCreated {
                vm.characters.onEach {
                    adapter = getRecycleViewAdapter(it)
                }.collect()
            }
        }
    }

    private fun getRecycleViewAdapter(characters: List<Character>): CharacterListAdapter {
        return CharacterListAdapter(characters){ character ->
            Toast.makeText(context, character.name, Toast.LENGTH_SHORT).show()
        }
    }


}