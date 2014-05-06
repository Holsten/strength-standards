package se.holsten.strength;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;


public class StandardsActivity extends Activity {

    private StrengthDataSource _dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standards);

        _dataSource = new StrengthDataSource(this);

        try {
            _dataSource.open();
            List<Exercise> list = _dataSource.getExercises();
            _dataSource.close();
        } catch (Exception ex) {
            String s = ex.getMessage();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.standards, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClicked(View view) {
        try {
            _dataSource.open();
            String text = _dataSource.getLevel(1, 76, 200);
            _dataSource.close();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
           String s = ex.getMessage();
        }
    }
}
