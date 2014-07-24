package dmhnorth.listviewdemo.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dave on 14/07/2014.
 */
public class MyAdapter extends ArrayAdapter<String> {

    //This constructor requires that you place the layout in the parameters
    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.custom_row_layout_2, values);
    }


//    Must find this method and implement it using ctrl-o (Android Studio)
//    the convertView parameter is for reusing an old view
//    ViewGroup represents a group of containers
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//      Inflater is used to get the details of the view from the current context
        LayoutInflater theInflater = LayoutInflater.from(getContext());

//      We must then find the individual component views within the designated xml
        View theView = theInflater.inflate(R.layout.custom_row_layout_2, parent, false);

        String person = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        theTextView.setText(person);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);

        theImageView.setImageResource(R.drawable.dot);

        return theView;
    }
}
