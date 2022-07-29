package sg.edu.rp.c346.id21018157.mymovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mymovies.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_MOVIES = "movies";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_RATING = "rating";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createNoteTableSql = "CREATE TABLE " + TABLE_MOVIES + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT ," + COLUMN_GENRE + " TEXT ,"
                    + COLUMN_YEAR + " INTEGER ," + COLUMN_RATING + " INTEGER ) ";
            db.execSQL(createNoteTableSql);
            Log.i("info", "created tables");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("ALTER TABLE " + TABLE_MOVIES + " ADD COLUMN  module_name TEXT ");
        }

        public long insertMovie(String movie, String genre, int year, String rating) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_TITLE, title);
            values.put(COLUMN_GENRE, genre);
            values.put(COLUMN_YEAR, year);
            values.put(COLUMN_RATING, rating);
            long result = db.insert(TABLE_MOVIES, null, values);
            Log.d("DBHelper", "Insert failed");
            db.close();
             //id returned, shouldn’t be -1
            return result;
        }
    }
}
