package sg.edu.rp.c346.id21018157.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowMovies extends AppCompatActivity {

    Button btnShow;
    ListView lv;
    ArrayList<Movie> al;
    ArrayAdapter<Movie> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        btnShow = findViewById(R.id.btnShow);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Movie>();
        aa = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(ShowMovies.this);
                al.clear();
                al.addAll(db.getPG());
                aa.notifyDataSetChanged();

                db.close();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Movie data = al.get(position);
                Intent i = new Intent(ShowMovies.this,
                        ModifyMovies.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
}