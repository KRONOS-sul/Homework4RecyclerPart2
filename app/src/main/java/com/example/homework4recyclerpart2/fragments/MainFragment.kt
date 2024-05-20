package com.example.homework4recyclerpart2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework4recyclerpart2.OnItemClick
import com.example.homework4recyclerpart2.R
import com.example.homework4recyclerpart2.adapters.MainAdapter
import com.example.homework4recyclerpart2.data.ContinentEntity
import com.example.homework4recyclerpart2.databinding.FragmentMainBinding

class MainFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentMainBinding
    private var rvList = ArrayList<ContinentEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadList()
        val adapter = MainAdapter(rvList, this)
        binding.continentsRv.adapter = adapter
    }

    private fun loadList() {
        rvList.add(
            ContinentEntity(
                "https://static.thenounproject.com/png/710124-200.png",
                "Eurasia"
            )
        )
        rvList.add(
            ContinentEntity(
                "https://i.pinimg.com/originals/65/53/00/655300a0698550e700b624fe4de367a8.png",
                "Africa"
            )
        )
        rvList.add(
            ContinentEntity(
                "https://static.thenounproject.com/png/710123-200.png",
                "Oceania"
            )
        )
        rvList.add(
            ContinentEntity(
                "https://cdn4.iconfinder.com/data/icons/maps-of-the-world/100/_-3-512.png",
                "South America"
            )
        )
        rvList.add(
            ContinentEntity(
                "https://static.thenounproject.com/png/301975-200.png",
                "North America"
            )
        )
    }

    override fun onItemClick(continent: ContinentEntity) {
        val bundle = Bundle().apply {
            putString("continentKey", continent.continentName)
        }

        val countriesFragment =
            CountriesFragment().apply { // тоже самое что и countriesFragment.arguments = bundle
                arguments = bundle
            }
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, countriesFragment)
            .addToBackStack(null).commit()
    }

}