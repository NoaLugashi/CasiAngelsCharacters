package com.example.casiangels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private List<Character> characterList;
    private List<Character> fullList;
    private Context context;

    public CharacterAdapter(List<Character> characterList, Context context) {
        this.characterList = new ArrayList<>(characterList);
        this.fullList = new ArrayList<>(characterList);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.nameTextView.setText(character.getName());
        holder.descTextView.setText(character.getDescription());
        holder.imageView.setImageResource(character.getImageResId());

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "You clicked on " + character.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void filter(String text) {
        characterList.clear();
        if (text.isEmpty()) {
            characterList.addAll(fullList);
        } else {
            text = text.toLowerCase();
            for (Character c : fullList) {
                if (c.getName().toLowerCase().contains(text)) {
                    characterList.add(c);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, descTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
        }
    }
}