package br.eng.rozsas.upsmonitor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OIDDataAdapter extends ArrayAdapter<OIDData> {

    private static final String TAG = "MYDEBUG: " + OIDDataAdapter.class.getSimpleName();

    public OIDDataAdapter(Context context, List<OIDData> oidData) {
        super(context, 0, oidData);
    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @androidx.annotation.Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {

        Log.d(TAG, "at beginning of getView");
        // Check if there is an existing list view (called convertedView here) that can be reused,
        // otherwise, if convertedView is null, then inflate a new list item layout
        View listItemView= convertView;
        if (listItemView==null) {
            listItemView= LayoutInflater.from(getContext()).
                    inflate(R.layout.oid_data_list_view, parent, false);
        }

        // Find the OIDResult at given position in the list of OIDResults
        Log.d(TAG, "before getItem");
        OIDData currentOIDData = (OIDData) getItem(position);

        // Find the all TextViews in the layout
        Log.d(TAG, "get the views");
        TextView descTV= listItemView.findViewById(R.id.item_description);
        TextView oidNameTV= listItemView.findViewById(R.id.item_oidName);
        TextView valueTV= listItemView.findViewById(R.id.item_value);

        // in each of theses textViews, set the text from the current OIDResult object
        Log.d(TAG, "setText on desc and name");
        descTV.setText(currentOIDData.getDesc());
        oidNameTV.setText(currentOIDData.getName());

        // fake result
        valueTV.setText("fake");
/*
        ResultType type= currentOIDData.getType ();
        String value= currentOIDData.getValue();
        String suffix= currentOIDData.getSuffix();

        // set the text view accordly to oid type
        // NUMERIC: convert to float, optionally apply the multiplier (if it is non zero) and add the suffix
        // STRING: just add the suffix
        // LIST of CHOICE: get the index from the result, get the value at that index, add the suffix
        switch (type) {
            case NUMERIC:
                float mult= currentOIDData.getMult();
                if (mult==0) {
                    // don't apply mult, output is an integer
                    valueTV.setText(value + suffix);
                } else {
                    // apply the multiplier as the output is a float
                    float numValue = mult * Integer.parseInt(value);
                    valueTV.setText(Float.toString(numValue) + suffix);
                }
                break;
            case STRING:
                valueTV.setText(value + suffix);
                break;
            case LIST_OF_CHOICES:
                String[] choices= currentOIDData.getChoices();
                int index= Integer.parseInt(value);
                valueTV.setText(choices[index] + suffix);
                break;
            default:
                valueTV.setText(currentOIDData.getValue());
        }*/
        Log.d(TAG, "at end of getView");
        return listItemView;
    }
}
