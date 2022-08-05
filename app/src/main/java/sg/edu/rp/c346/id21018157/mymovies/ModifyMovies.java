package sg.edu.rp.c346.id21018157.mymovies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyMovies extends AppCompatActivity {
    EditText etID, etTitle, etGenre, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    Spinner ratingSpinner;
    String[] populateRating;
    ArrayAdapter spinnerAdapter;
    Movie data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movies);
        populateRating = new String[] {"G", "PG", "PG13", "NC16", "M18", "R21"};
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, populateRating);

        etID = findViewById(R.id.readOnlyID);
        etTitle = findViewById(R.id.modifyTitle);
        etGenre = findViewById(R.id.modifyGenre);
        etYear = findViewById(R.id.modifyYear);
        ratingSpinner = findViewById(R.id.modifyRatingSpinner);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);


        //initialise variables
        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        etID.setText("" + data.getId());
        etTitle.setText(data.getTitle());
        etGenre.setText(data.getGenre());
        etYear.setText("" + data.getYear());
        ratingSpinner.setAdapter(spinnerAdapter);

        // this for loop is used to loop through the array.
        // if the values in the array matches the parsed in object rating,
        // set the spinner value to the parsed in rating
        for(int j = 0; j < populateRating.length; j++){
            if(populateRating[j].equalsIgnoreCase(data.getRating())){
                ratingSpinner.setSelection(j);
            }
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this code is used to get the spinner current textview
                TextView getSpinnerTV = (TextView)ratingSpinner.getSelectedView();
                DBHelper db = new DBHelper(ModifyMovies.this);
                data.setTitle(etTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));

                // and this is used to convert the textview into a string.
                data.setRating(getSpinnerTV.getText().toString());

                db.updateMovie(data);
                db.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovies.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie " + data.getTitle());
                myBuilder.setCancelable(true);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper db = new DBHelper(ModifyMovies.this);
                        db.deleteMovie(data.getId());
                        Toast.makeText(ModifyMovies.this, "Movie deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovies.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to discard the changes");
                myBuilder.setCancelable(true);

                myBuilder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

    }
}


