package com.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.R
import com.rickandmorty.models.UICharacter
import kotlinx.android.synthetic.main.fragment_character_item.view.*

class CharacterAdapter(private val characters: ArrayList<UICharacter>) : RecyclerView.Adapter<CharacterAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: UICharacter) {
            itemView.apply {
                tcCharacterName.text = character.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_character_item, parent, false))

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    fun addCharacters(characters: List<UICharacter>) {
        this.characters.apply {
            addAll(characters)
        }
    }
}