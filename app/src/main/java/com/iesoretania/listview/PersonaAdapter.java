package com.iesoretania.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    private final Context ctx;
    private final int layoutTemplate;
    private final List<Persona> modulolist;

    public PersonaAdapter(@NonNull Context context, int resource, @NonNull List<Persona> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.modulolist = objects;
    }

    private static class ViewHolder {
        TextView textviewmodulo;
        ImageView imageviewmodulo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);
            holder = new ViewHolder();
            holder.textviewmodulo = convertView.findViewById(R.id.item_text);
            holder.imageviewmodulo = convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Persona elementoActual = modulolist.get(position);
        holder.textviewmodulo.setText(elementoActual.getCiclos());

        switch (elementoActual.getCiclos()) {
            case "ASIR":
                holder.imageviewmodulo.setImageResource(R.drawable.local_network);
                break;
            case "DAW":
                holder.imageviewmodulo.setImageResource(R.drawable.global);
                break;
            case "DAM":
                holder.imageviewmodulo.setImageResource(R.drawable.responsive_web);
                break;
        }

        if ()

        return convertView;
    }
}
