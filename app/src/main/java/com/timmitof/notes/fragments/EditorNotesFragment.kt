package com.timmitof.notes.fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.timmitof.notes.Constants
import com.timmitof.notes.Constants.Companion.counterId
import com.timmitof.notes.Constants.Companion.notes
import com.timmitof.notes.MainActivity
import com.timmitof.notes.R
import com.timmitof.notes.models.Notes

class EditorNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_editor_notes, container, false)

        val nameEd: EditText = view.findViewById(R.id.name_editor)
        val shortDescription: EditText = view.findViewById(R.id.short_description_editor)
        val detailedDescription: EditText = view.findViewById(R.id.detailed_description_editor)
        val startDateEvent: EditText = view.findViewById(R.id.start_event_editor)
        val endDateEvent: EditText = view.findViewById(R.id.end_event_editor)
        val userNotes: EditText = view.findViewById(R.id.user_notes_editor)

        val saveBtn: Button = view.findViewById(R.id.save_btn)
        val backBtn: Button = view.findViewById(R.id.back_on_main)

        val note = requireArguments().getSerializable("NOTES") as Notes

        nameEd.setText(note.name)
        shortDescription.setText(note.shortDescription)
        detailedDescription.setText(note.detailedDescription)
        startDateEvent.setText(note.startDateEvent)
        endDateEvent.setText(note.endDateEvent)
        userNotes.setText(note.userNotes)

        saveBtn.setOnClickListener {
            for(item in notes){
                if (note.id == item.id){
                    item.name = nameEd.text.toString()
                    item.shortDescription = shortDescription.text.toString()
                    item.detailedDescription = detailedDescription.text.toString()
                    item.startDateEvent = startDateEvent.text.toString()
                    item.endDateEvent = endDateEvent.text.toString()
                    item.userNotes = userNotes.text.toString()

                    Toast.makeText(activity, "Note update successfully", Toast.LENGTH_SHORT).show()

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragment_container, MainFragment())?.commit()

                    Log.d("@@@@", "Update notes: ${item}")
                }
            }
        }

        backBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, MainFragment())?.commit()
        }

        return view

    }

}

