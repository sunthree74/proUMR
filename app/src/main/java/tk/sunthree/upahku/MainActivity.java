package tk.sunthree.upahku;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // List view
    private ListView lv;
    private Toolbar toolbar;
    private EditText inputSearch;
    private TextInputLayout inputLayoutSearch;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
//    EditText inputSearch;

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> negaraList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("UMR Apps");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputLayoutSearch = (TextInputLayout) findViewById(R.id.input_search_layout);
        inputSearch = (EditText) findViewById(R.id.input_search);

       // Data Array yang akan ditampilkan di list
       String kota[] = {"DKI Jakarta","Papua","Sulawesi Utara","Kepulauan Bangka Belitung",
               "Sulawesi Selatan" };
       int ump[] = {3100000,2435000,2400000,2314500,225000};
       // ambil list_view dan inputsearchnya di xml
       lv = (ListView) findViewById(R.id.listKota);
       inputSearch = (EditText) findViewById(R.id.input_search);

       // proses menambahkan array kedalam listview
       adapter = new ArrayAdapter<String>(this, R.layout.item_list,
               R.id.txt1, kota);
       lv.setAdapter(adapter);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               String nama_kota = lv.getItemAtPosition(position).toString();
               Intent intent = new Intent(getApplicationContext(),Chart.class);

               startActivity(intent);
           }
       });

       inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
