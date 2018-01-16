package com.cet325.bg69pt;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ArtDB";

    private static final String TABLE_ART = "art";

    private static final String KEY_ID = "id";
    private static final String KEY_ARTIST = "artist";
    private static final String KEY_TITLE = "title";
    private static final String KEY_ROOM = "room";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_YEAR = "year";
    private static final String KEY_RATE = "rate";
    private static final String KEY_OWNED = "owned";

    private static final String[] COLUMNS = {KEY_ID, KEY_ARTIST, KEY_TITLE, KEY_ROOM, KEY_DESCRIPTION, KEY_IMAGE, KEY_YEAR, KEY_RATE, KEY_OWNED};

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ART_TABLE = "CREATE TABLE art (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "artist TEXT" +
                "title TEXT" +
                "room TEXT" +
                "description TEXT" +
                "image TEXT" +
                "year VARCHAR" +
                "rank VARCHAR" +
                "owned boolean)";
        db.execSQL(CREATE_ART_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS art");

        this.onCreate(db);
    }

    public void addArt(Art art) {
        Log.d("addArt", art.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ARTIST, art.artist);
        values.put(KEY_TITLE, art.title);
        values.put(KEY_ROOM, art.room);
        values.put(KEY_DESCRIPTION, art.description);
        values.put(KEY_IMAGE, art.image);
        values.put(KEY_YEAR, art.year);
        values.put(KEY_RATE, art.rank);

        db.insert(TABLE_ART, null, values);

        db.close();

    }

    public Art getArt(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_ART, COLUMNS, "id = ?",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);

        Art art = null;

        if (cursor !=null && cursor.moveToFirst());{
            art = new Art();
            art.id = Integer.parseInt(cursor.getString(0));
            art.image = cursor.getString(1);
            art.artist = cursor.getString(2);
            art.title = cursor.getString(3);
            art.room = cursor.getString(4);
            art.description = cursor.getString(5);
            art.year = cursor.getInt(6);
            art.rank = cursor.getInt(7);

            Log.d("getArt("+id+")", art.toString());
        }
        return art;
    }

    public void deleteArt (Art art) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ART,
                KEY_ID+ " = ?",
                new String[] { String.valueOf(art.id)});

        db.close();

        Log.d("deleteArt", art.toString());

    }
}







