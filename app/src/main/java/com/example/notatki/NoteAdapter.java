package com.example.notatki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_note, parent, false);
        }

        Note note = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.textNoteTitle);
        TextView contentTextView = convertView.findViewById(R.id.textNoteContent);

        if (note != null) {
            titleTextView.setText(note.getTitle());
            contentTextView.setText(note.getContent());
        }

        return convertView;
    }
}
