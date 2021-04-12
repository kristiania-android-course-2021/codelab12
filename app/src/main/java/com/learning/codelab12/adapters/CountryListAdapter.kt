package com.learning.codelab12.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.codelab12.databinding.ItemCountryViewBinding
import com.learning.codelab12.models.CountryStats
import com.squareup.picasso.Picasso


class CountryListAdapter(private var list: List<CountryStats>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding =  ItemCountryViewBinding.inflate(LayoutInflater.from(parent.context))
        return CountryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class CountryViewHolder(private val binding: ItemCountryViewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(stats: CountryStats) {
            Picasso.get().load("https://www.countryflags.io/${stats.CountryCode}/shiny/64.png").into(binding.imageViewFlag);
            binding.textViewCountry.text  = stats.Country
            binding.textViewCountryCases.text = "${stats.TotalConfirmed}"
        }
    }

    fun update(newList: List<CountryStats>){
        list = newList
        notifyDataSetChanged()
    }

}