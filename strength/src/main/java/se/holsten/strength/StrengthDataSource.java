package se.holsten.strength;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by fredrik.holstensson on 2014-04-22.
 */
public class StrengthDataSource {

    private SQLiteDatabase database;
    private StrengthDatabaseHelper databaseHelper;

    public StrengthDataSource(Context context) {
        databaseHelper = new StrengthDatabaseHelper(context);
    }

    public void open() {
        database = databaseHelper.getReadableDatabase();
    }

    public void close() {
        databaseHelper.close();
    }

    public String getLevel(int exercise, double bodyWeight, double weight) {
        String sql = "select level.name " +
                "from standard " +
                "left join exercise on standard.fk_exercise_id = exercise._id " +
                "left join level on standard.fk_level_id = level._id " +
                "where fk_exercise_id = ? " +
                "and standard.bodyweight <= ? " +
                "and standard.weight >= ? " +
                "order by standard.bodyweight desc, standard.weight asc " +
                "limit 1 ";
        Cursor cursor = database.rawQuery(sql, new String[]{
                String.valueOf(exercise),
                String.valueOf(bodyWeight),
                String.valueOf(weight)});
        if (cursor != null)
            if (cursor.moveToFirst())
                return cursor.getString(0);
        return "";
    }

    public List<Exercise> getExercises() {
        List<Exercise> exercises = new ArrayList<Exercise>();
        String sql = "select _id, name from exercise order by _id";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null)
            while (cursor.moveToNext()) {
                Exercise exercise = new Exercise(
                        cursor.getInt(0),
                        cursor.getString(1)
                );
                exercises.add(exercise);
            }
        return exercises;
    }
}