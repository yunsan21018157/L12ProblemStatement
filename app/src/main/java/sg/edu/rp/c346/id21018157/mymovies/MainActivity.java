package sg.edu.rp.c346.id21018157.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin.findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        rating = "G";
                        break;

                    case 1:
                        rating = "PG";
                        break;

                    case 2:
                        rating = "PG13";
                        break;

                    case 3:
                        rating = "NC16";
                        break;

                    case 4:
                        rating = "M18";
                        break;

                    case 5:
                        rating = "R21";
                        break;

                    default:
                        rating = " ";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
//new