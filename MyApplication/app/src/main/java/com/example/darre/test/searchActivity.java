package com.example.darre.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by darre on 01/02/2017.
 */

public class searchActivity extends AppCompatActivity {

    private ListView ListSearch;
    private EditText EditSearch;
    private ArrayAdapter<String> adapter;
    private Map<String, Integer> mapIndex;
    private String[] Data;

    ArrayList<String> SelectedItems = new ArrayList<>();//Created an Array list to put the data in the array list



    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);
        init();
        ListSearch.setAdapter(new CustomAdapter(this, Arrays.asList(Data)));
        //getIndexList(Data);
        // displayIndex();


        EditSearch = (EditText) findViewById(R.id.EditSearch);
        ListView LV = (ListView) findViewById(R.id.ListSearch);


        adapter = new ArrayAdapter<String>(this, R.layout.list_item, /*chkBox,*/ Data);
        LV.setAdapter(adapter);//ListView is assigned to the adapter
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SI = ((TextView) view).getText().toString();//Once clicked go to the if statement

                if (SelectedItems.contains(SI)) {
                    SelectedItems.remove(SI); //uncheck the item
                } else {
                    SelectedItems.add(SI);//check the item
                }

            }
        });

        EditSearch.addTextChangedListener(new TextWatcher() {
                                              @Override
                                              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                              }

                                              @Override
                                              public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                  searchActivity.this.adapter.getFilter().filter(s);//When user types the lists gets narrowed down
                                              }

                                              @Override
                                              public void afterTextChanged(Editable s) {
                                                  // EditSearch.setError("Field cannot be left blank.");
                                              }
                                          }

        );

    }


    private void init()
    {
        ListSearch = (ListView)findViewById(R.id.ListSearch);
        Data = getResources().getStringArray(R.array.sports_array);
        Arrays.sort(Data);
    }




}


//For the alhpabet scroll view
    /*private void getIndexList(String[] test)
    {
        mapIndex = new LinkedHashMap<String, Integer>();
        for(int i = 0; i< ContactsContract.Contacts.Data.length; i++)
        {
            String sport = Data[i];
            String index = sport.substring(0,1);

            if(mapIndex.get(index) == null)
                mapIndex.put(index, i);
        }
    }

    //Displaying the scroll view
    private void displayIndex()
    {
        LinearLayout indexLayout = (LinearLayout)findViewById(R.id.activity_main);
        List<String> indexList = new ArrayList<String>(mapIndex.keySet());

        TextView textView1;
        for(String index : indexList)
        {
            textView1 = (TextView) getLayoutInflater().inflate(R.layout.alphabet_indicator, null);
            textView1.setText(index);
            textView1.setOnClickListener(this);
            indexLayout.addView(textView1);
        }
    }

    @Override
    public void onClick(View v) {
        TextView selectedTextView  = (TextView) v;
        ListSearch.setSelection(mapIndex.get(selectedTextView.getText()));
    }


*/


