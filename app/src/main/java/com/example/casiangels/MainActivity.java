package com.example.casiangels;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private SearchView searchView;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);

        characterList = new ArrayList<>();
        characterList.add(new Character("Thiago Bedoya Agüero", "The rebellious and charismatic boy who falls in love with Mar. He leads the group and is the son of the orphanage's director. He seeks the truth about his past and the orphanage.", R.drawable.thiago));
        characterList.add(new Character("Marianella 'Mar' Rinaldi", "A strong and independent girl with a tough past. She falls in love with Thiago and leads the orphans in their struggle.", R.drawable.mar));
        characterList.add(new Character("Nicolas Bauer", "The mysterious fiancé of the director's sister (Malvina), who hides many secrets and helps the orphans.", R.drawable.nico));
        characterList.add(new Character("Cielo Mágico", "The elegant and mysterious acrobat who connects the children to a world of magic and music. Helps them fight the orphanage director alongside Nicolas and falls in love with him.", R.drawable.cielo));
        characterList.add(new Character("Rama Ordoñez", "A loyal and good-hearted friend, grew up in the orphanage with his little sister. Sometimes funny, sometimes serious. A talented musician searching for his place.", R.drawable.rama));
        characterList.add(new Character("Tacho", "Grew up in orphanages, impulsive yet sensitive. Struggles with personal challenges and searches for love.", R.drawable.tacho));
        characterList.add(new Character("Justina García", "The strict and controlling orphanage manager, who makes the children's lives difficult while serving the director.", R.drawable.justina));
        characterList.add(new Character("Malvina", "Sister of the orphanage director. Engaged to Nico for love and also to secure inheritance. Abuses the children as well.", R.drawable.malvina));
        characterList.add(new Character("Bartolomé Bedoya Agüero", "The orphanage director, Thiago's father. Abuses the children, forcing them to work and steal instead of studying.", R.drawable.bartolome));
        characterList.add(new Character("Simón Rodríguez", "Thiago's best friend, a kind-hearted guy who joins later in the series (season 2). Falls in love with Mar, faces his past, and helps the group.", R.drawable.simon));
        characterList.add(new Character("Jazmín", "A gypsy dancer who grew up on the streets and joins the orphanage. There, she becomes Mar's best friend and falls in love with Tacho.", R.drawable.jazmin));

        adapter = new CharacterAdapter(characterList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
    }
}