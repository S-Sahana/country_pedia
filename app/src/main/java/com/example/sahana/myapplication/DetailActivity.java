package com.example.sahana.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class DetailActivity extends Activity {
     Button click;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            //setContentView(R.layout.fragment_detail);
            click = ((Button)findViewById(R.id.button));
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new DetailFragment())
                        .commit();
            }

        }

   public void OnClick(View view){
       Intent onclick_intent = new Intent(this,Contact_check.class);
       startActivity(onclick_intent);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        public String CountryName;
        public HashMap<String,String> Map =  new HashMap<String,String>();
        public HashMap<String,String> Continent_Map = new HashMap<String,String>();
        public HashMap<String,String> PhonecodeMap = new HashMap<String,String>();
        public HashMap<String,String> CurrencyMap= new HashMap<String,String>();
        public String S1;
        public String forecastJsonstr;
        public String[] URLS = {
                "http://country.io/names.json",
                "http://country.io/continent.json",
                "http://country.io/capital.json",
                "http://country.io/currency.json",
                "http://country.io/phone.json"
        };
        int newIndex;
        private String CountryName1;

        public DetailFragment() {
        }









        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

           // class1.onPostExecute(class1.doInBackground());
            String Countrycode = new String();
            String Continent;
            String PhoneCode;
            String Currency;
            int i = 0;

            Intent intent1 = getActivity().getIntent();

            ((TextView) rootView.findViewById(R.id.CountryID)).setText(forecastJsonstr);
            if (intent1 != null && intent1.hasExtra(Intent.EXTRA_TEXT)&& intent1.hasExtra(Intent.EXTRA_EMAIL)&& intent1.hasExtra("XYZ")&& intent1.hasExtra("Currency")&& intent1.hasExtra("PhoneCode") ) {
                int index =0;
                CountryName = intent1.getStringExtra(Intent.EXTRA_TEXT);
                Countrycode = intent1.getStringExtra(Intent.EXTRA_EMAIL);
                Continent = intent1.getStringExtra("XYZ");
                PhoneCode = intent1.getStringExtra("PhoneCode");
                Currency = intent1.getStringExtra("Currency");
                Currency = Currency.replaceAll(" ","");
                Currency = Currency.replaceAll("[{}\"]","");
                PhoneCode = PhoneCode.replaceAll(" ","");
                PhoneCode = PhoneCode.replaceAll("[{}\"]","");
                Continent = Continent.replaceAll(" ","");
                Continent = Continent.replaceAll("[{}\"]","");
                String[] Phonecode = PhoneCode.split("[:,]");
                String[] Continent_Code = Continent.split("[:,]");
                String[] CurrencyCode = Currency.split("[:,]");
                for(i=0;i<Continent_Code.length-1;i=i+2) {
                    Continent_Map.put(Continent_Code[i], Continent_Code[i + 1]);
                    PhonecodeMap.put(Phonecode[i],Phonecode[i+1]);
                    CurrencyMap.put(CurrencyCode[i],CurrencyCode[i+1]);
                }
                CountryName1 = ""+CountryName;
                String First = Countrycode.substring(0,247);
                String Second = Countrycode.substring(280,Countrycode.length());
                String Together = ""+First+Second+"";
                String[] CountryCode_generator = Together.split("[:,]");

                for(i=0;i<CountryCode_generator.length-1;i=i+2){

                    Map.put(CountryCode_generator[i+1],CountryCode_generator[i]);
                }
                Map.put("BonaireSaintEustatiusandSaba","BQ");






                // int index = result.indexOf(String.valueOf(CountryName));
                // int newIndex = index - 6;
                        ((TextView) rootView.findViewById(R.id.CountryID)).setText("Country Name : " + CountryName);
                ((TextView) rootView.findViewById(R.id.Countrycode)).setText("Country code : "+Map.get(CountryName.replaceAll(" ","")));

                //Map.get(CountryName.replaceAll(" ",""))
                ((TextView) rootView.findViewById(R.id.Continent)).setText("Continent Code: "+Continent_Map.get(Map.get(CountryName.replaceAll(" ",""))));
                ((TextView) rootView.findViewById(R.id.phonecode)).setText("Phone Code: "+PhonecodeMap.get(Map.get(CountryName.replaceAll(" ",""))));
                ((TextView) rootView.findViewById(R.id.currency)).setText("Currency: "+CurrencyMap.get(Map.get(CountryName.replaceAll(" ",""))));
            }


            return rootView;
        }

    }
}