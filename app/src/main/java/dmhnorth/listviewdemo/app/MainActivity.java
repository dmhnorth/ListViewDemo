package dmhnorth.listviewdemo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //example list
        String[] peopleList = {"Dave", "Olly", "Joe", "Ryan", "Mike", "Ludo", "John", "Bean",
                "Slime", "Bazzer", "Frump pop", "Dingo", "Congo Natty"};

        //custom adapter used to create the list. Parameters are (context, dataSet)
        ListAdapter listAdapter = new MyAdapter(this, peopleList);

        //Find the ListView and use it
        ListView listView = (ListView) findViewById(R.id.theListView);

        //Set the ListView Adapter we want to use
        listView.setAdapter(listAdapter);

        //Set a listener by creating and and implementing the method onItemClick()
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String personPicked = "You picked " + String.valueOf(adapterView.getItemAtPosition(position));

                //Display the text of who was picked
                Toast.makeText(MainActivity.this, personPicked, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

}
