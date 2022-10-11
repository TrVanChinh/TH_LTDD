package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {
    ListView lvGame;
    ArrayList<game> arrayGame;
    gameAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        AnhXa();

        adapter = new gameAdapter(this, R.layout.dong_game, arrayGame);
        lvGame.setAdapter(adapter);
    }
    private void AnhXa(){
        lvGame = (ListView) findViewById(R.id.listviewgame);
        arrayGame = new ArrayList<>();

        arrayGame.add(new game("Garena Liên Quân Mobile","Hành động . Phiêu lưu","3.5", "187MB", R.drawable.ic_baseline_star_24,R.drawable.lienquan,"1"));
        arrayGame.add(new game("PUBG Mobile","Hành động . Bắn súng chiến thuật","3.2", "167MB", R.drawable.ic_baseline_star_24,R.drawable.pubg, "2"));
        arrayGame.add(new game("Loạn chiến Mobile","Hành động","3.1", "364MB", R.drawable.ic_baseline_star_24,R.drawable.loanchien, "3"));
        arrayGame.add(new game("Garena Free Fire","Hành động . Bắn súng","4.1", "507MB", R.drawable.ic_baseline_star_24,R.drawable.freefire, "4"));
        arrayGame.add(new game("Snake Lite - trò chơi rắn","Hành động . Trò chơi io","4.2", "45MB", R.drawable.ic_baseline_star_24,R.drawable.sanke_lite, "5"));
        arrayGame.add(new game("Among Us","Hành động . Chiến thuật","3.6", "76MB", R.drawable.ic_baseline_star_24,R.drawable.amongus, "6"));

    }
}