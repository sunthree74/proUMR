package tk.sunthree.upahku;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryList extends ListFragment {

    // Array of strings storing country names
    String[] countries = new String[] {
            "Upah Buruh Tinggi jadi Alasan Industri Keluar dari Banten?",
            "Menaker: 26 Provinsi Sudah Laporkan Penetapan UMP 2019",
            "Kenaikan UMP di 8 Daerah Ini Bisa Lebih Tinggi dari Provinsi Lain",
            "Tak Patuh Aturan UMP 2019, Pengusaha Terancam 4 Tahun Penjara",
            "Kepala Daerah Bisa Dicopot Jika Kenaikan UMP Kurang dari 8,03%",
            "Naik 8%, Ini Perkiraan UMP 2019 di 34 Provinsi",
            "Kenaikan UMP di 8 Daerah Ini Bisa Lebih Tinggi dari Provinsi Lain",
            "Tak Patuh Aturan UMP 2019, Pengusaha Terancam 4 Tahun Penjara",
            "Kepala Daerah Bisa Dicopot Jika Kenaikan UMP Kurang dari 8,03%",
            "Naik 8%, Ini Perkiraan UMP 2019 di 34 Provinsi",
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b
    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "Jumat, 16 Nov 2018 10:41 WIB",
            "Jumat, 02 Nov 2018 19:30 WIB",
            "Kamis, 01 Nov 2018 19:11 WIB",
            "Kamis, 01 Nov 2018 18:19 WIB",
            "Kamis, 01 Nov 2018 18:02 WIB",
            "Rabu, 17 Okt 2018 16:16 WIB",
            "Kamis, 01 Nov 2018 19:11 WIB",
            "Kamis, 01 Nov 2018 18:19 WIB",
            "Kamis, 01 Nov 2018 18:02 WIB",
            "Rabu, 17 Okt 2018 16:16 WIB",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "Judul : " + countries[i]);
            hm.put("cur","Date : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
