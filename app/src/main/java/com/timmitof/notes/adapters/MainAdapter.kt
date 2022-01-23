package com.timmitof.notes.adapters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.notes.Constants
import com.timmitof.notes.R
import com.timmitof.notes.fragments.EditorNotesFragment
import com.timmitof.notes.models.Notes

class MainAdapter(private var array: ArrayList<Notes>, private val context: FragmentActivity) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_notes)
        val shortDescription: TextView = view.findViewById(R.id.short_description)
        val detailedDescription: TextView = view.findViewById(R.id.detailed_description)
        val startDateEvent: TextView = view.findViewById(R.id.start_event_date)
        val endDateEvent: TextView = view.findViewById(R.id.end_event_date)
        val userNotes: TextView = view.findViewById(R.id.user_notes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_cell_in_main_fragment, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.name.text = item.name
        holder.shortDescription.text = item.shortDescription
        holder.detailedDescription.text = item.detailedDescription
        holder.startDateEvent.text = item.startDateEvent
        holder.endDateEvent.text = item.endDateEvent
        holder.userNotes.text = item.userNotes

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("NOTES", item)

            context.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EditorNotesFragment::class.java, bundle)
                .addToBackStack(null).commit()
        }

    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun deleteItem(i: Int){
        Constants.notes.removeAt(i)
        notifyDataSetChanged()
    }
}
