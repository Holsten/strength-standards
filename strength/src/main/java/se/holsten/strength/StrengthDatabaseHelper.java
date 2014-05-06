package se.holsten.strength;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.InputStream;

public class StrengthDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "strength.db";
    private static final int DATABASE_VERSION = 5;
    private static Context _myContext;

    public StrengthDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        _myContext = context;
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        processFile(R.raw.table_exercise, database);
        processFile(R.raw.table_level, database);
        processFile(R.raw.table_standard, database);
        processFile(R.raw.table_max, database);
    }

    // Method is called during an upgrade of the database,
    // e.g. if you increase the database version
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onCreate(database);
    }

    private void processFile(int resource, SQLiteDatabase database) {
        String string = getRaw(resource);
        String[] array = string.split(";");
        for(String item : array) {
            String sql = item.trim();
            if (!sql.isEmpty()) {
                try {
                    database.execSQL(item);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private String getRaw(int resource) {
        String sql = null;
        try {
            InputStream stream = _myContext.getResources().openRawResource(resource);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            sql = new String(buffer);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return sql;
    }
}