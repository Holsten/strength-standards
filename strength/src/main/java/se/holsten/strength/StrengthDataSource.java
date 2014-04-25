package se.holsten.strength;

import java.util.ArrayList;
import java.util.List;

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
                "where fk_exercise_id = " + String.valueOf(exercise) + " " +
                "and standard.bodyweight <= " + String.valueOf(bodyWeight) + " " +
                "and standard.weight >= " + String.valueOf(weight) + " " +
                "order by standard.bodyweight desc, standard.weight asc " +
                "limit 1 ";
        //Cursor cursor = database.rawQuery(sql, new String[]{
        //        String.valueOf(exercise),
        //        String.valueOf(bodyWeight)
        //        , String.valueOf(weight)});
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor != null)
            if (cursor.moveToFirst())
                return cursor.getString(0);
        return "";
    }
}