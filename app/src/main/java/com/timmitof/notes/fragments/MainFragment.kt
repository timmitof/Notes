package com.timmitof.notes.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.notes.Constants.Companion.counterId
import com.timmitof.notes.Constants.Companion.notes
import com.timmitof.notes.R
import com.timmitof.notes.adapters.MainAdapter
import com.timmitof.notes.models.Notes

class MainFragment : Fragment() {
    lateinit var addNotesBtn: FloatingActionButton
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        addNotesBtn = view.findViewById(R.id.add_notes_btn)

        recyclerView = view.findViewById(R.id.recyclerView_main)
        recyclerView.adapter = MainAdapter(notes, requireActivity())

        addNotesBtn.setOnClickListener {
            addNotesDialog()
        }

        return view
    }

    private fun addNotesDialog() {
        val alert = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater.inflate(R.layout.add_notes, null)
        alert.setView(inflater)

        val addBtn: Button = inflater.findViewById(R.id.add_btn)
        val backBtn: Button = inflater.findViewById(R.id.back_btn)

        val name = inflater.findViewById<EditText>(R.id.name_editText)
        val shortDescription = inflater.findViewById<EditText>(R.id.short_description_editText)
        val detailedDescription =
            inflater.findViewById<EditText>(R.id.detailed_description_editText)
        val startDateEvent = inflater.findViewById<EditText>(R.id.start_event_editText)
        val endDateEvent = inflater.findViewById<EditText>(R.id.end_event_editText)
        val userNotes = inflater.findViewById<EditText>(R.id.user_notes_editText)

        val dialog = alert.create()

        backBtn.setOnClickListener {
            dialog.dismiss()
        }

        addBtn.setOnClickListener {
            notes.add(
                Notes(
                    counterId,
                    name.text.toString(),
                    shortDescription.text.toString(),
                    detailedDescription.text.toString(),
                    startDateEvent.text.toString(),
                    endDateEvent.text.toString(),
                    userNotes.text.toString(),
                )
            )
            counterId++
            Log.d("@@@@", "Added notes: ${notes}")
            dialog.dismiss()
        }
        dialog.show()
    }


    // Шпаргалка

    //    fun addElementToCart(note: Notes) {
//        if (counter <= 0) return
//        val cartProduct = CartProduct(product, counter)
//        var contain = true
//        if (addedProducts.isEmpty()) {
//            addedProducts.add(cartProduct)
//        } else {
//            for (addedProd in addedProducts){
//                contain = addedProd.product.id == product.id
//            }
//            if (contain){
//                Log.d("CART", "Такой продукт уже есть")
//            }else{
//                addedProducts.add(cartProduct)
//            }
//        }
//    }
}