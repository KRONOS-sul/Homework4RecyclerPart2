package com.example.homework4recyclerpart2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework4recyclerpart2.adapters.CountryAdapter
import com.example.homework4recyclerpart2.data.CountryEntity
import com.example.homework4recyclerpart2.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding
    private var rvList = ArrayList<CountryEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCountriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continentName =
            arguments?.getString("continentKey") ?: return //?: return чтобы ошибка не вылезала
        loadList(continentName)

        binding.screenNameTv.text = continentName

        val adapter = CountryAdapter(rvList)
        binding.countriesRv.adapter = adapter
    }

    private fun loadList(continent: String) {
        rvList.apply {
            when (continent) {
                "Eurasia" -> addAll(
                    listOf(
                        CountryEntity("Russia"),
                        CountryEntity("China"),
                        CountryEntity("India"),
                        CountryEntity("Germany"),
                        CountryEntity("France")
                    )
                )

                "Africa" -> addAll(
                    listOf(
                        CountryEntity("Nigeria"),
                        CountryEntity("Ethiopia"),
                        CountryEntity("Egypt"),
                        CountryEntity("South Africa"),
                        CountryEntity("Kenya")
                    )
                )

                "Oceania" -> addAll(
                    listOf(
                        CountryEntity("Australia"),
                        CountryEntity("New Zealand"),
                        CountryEntity("Fiji"),
                        CountryEntity("Papua New Guinea"),
                        CountryEntity("Samoa")
                    )
                )

                "South America" -> addAll(
                    listOf(
                        CountryEntity("Brazil"),
                        CountryEntity("Argentina"),
                        CountryEntity("Colombia"),
                        CountryEntity("Chile"),
                        CountryEntity("Peru")
                    )
                )

                "North America" -> addAll(
                    listOf(
                        CountryEntity("United States"),
                        CountryEntity("Canada"),
                        CountryEntity("Mexico"),
                        CountryEntity("Cuba"),
                        CountryEntity("Jamaica")
                    )
                )
            }
        }
    }
}