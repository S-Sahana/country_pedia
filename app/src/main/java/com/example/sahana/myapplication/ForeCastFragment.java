package com.example.sahana.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebHistoryItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sahana on 09-04-2018.
 */
public class ForeCastFragment extends Fragment {
    public ArrayAdapter<String> mForecastadapter;
    public String newstr = new String();
    public String[] nextarray;
    public String[] Country_name;
    public String[] arraystr;

    public String[] Continent;
    public String continent;
    public String[] Continent1;
    public String currency;
    public String phoneCode;
    public ForeCastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            Intent intent = new Intent(this.getActivity(),Contact_check.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        FetchWeatherTask Ftask = new FetchWeatherTask();
        Ftask.execute("a");
        Newclass class1 = new Newclass();
        class1.execute("b");
        Continent_class C_class = new Continent_class();
        C_class.execute("c");
        Currency Currency_class = new Currency();
        Currency_class.execute("d");
        phonecode pcode = new phonecode();
        pcode.execute("e");
        String[] forecastArray = {"",
                "",
                "",
                "",
                "",
                "",
        };



        List<String> weekforecast = new ArrayList<String>(Arrays.asList(forecastArray));
        mForecastadapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekforecast);
        ListView listview = (ListView) rootView.findViewById(R.id.listview_forecast);
        listview.setAdapter(mForecastadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String forecast = String.valueOf(mForecastadapter.getItem(position).toString());
               // String getindex = "\"" + forecast +"\"";

                Country_name = newstr.split("[:,]");
                int x = Country_name.length;
                for (int i = 0; i < Country_name.length; i++) {
                    Country_name[i] = Country_name[i].replaceAll("[{}\"]", "");
                  Country_name[i] = Country_name[x-1-i];
                }

                newstr= newstr.replaceAll("[{}\"]","");
                newstr = newstr.replaceAll(" ","");

                //arraystr = newstr.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
               // for(int i =1,j=0;i<(Country_name.length-1)&&j<Country_name.length;i=i+2,j++) {
               //     arraystr[j] = Country_name[i-1] + Country_name[i];
                //}
//                int h = arraystr.length;
               /* for (int i = 0; i < arraystr.length; i++)
                {
                    for (int j = i + 1; j < arraystr.length; j++)
                    {
                        if (arraystr[i].compareTo(arraystr[j])>0)
                        {
                            String temp = arraystr[i];
                            arraystr[i] = arraystr[j];
                            arraystr[j] = temp;
                        }
                    }
                }*/
                //nextarray = new String[arraystr.length];
                //for(int i =0;i<arraystr.length;i++){
                 //   nextarray[i] = arraystr[i].replaceAll("[{}\":,]","");
                 //   nextarray[i] = nextarray[i].replaceAll(" ","");
                //    Log.v("nextarray " ,"bbb "+ nextarray[i]);
               // }

                String CountryID = new String();
                int i = 0;

                    CountryID = newstr;// Country_name[position];



               int index = 0;

                index = newstr.indexOf(forecast);
                int newIndex = index - 6;
//oast.makeText(getActivity(),index,Toast.LENGTH_SHORT).show();

                //String CountryID = (position==0?"AF":position==1?"AX":position==2?"AL":position==3?"DZ":position==4?"AS":position==5?"AD":position==6?"AO":position==7?"AI":position==8?"AQ":position==9?"AG":position==10?"AR":position==11?"AM":position==12?"AW":position==13?"AU":position==14?"AT":position==15?"AZ":position==15?"BS":position==16?"BH":position==17?"BD":position==18?"BB":position==19?"BY":position==20?"BE":position==21?"BZ":position==22?"BJ":position==23?"":position==24?"":position==25?"":position==26?"":position==27?"AM":position==28?"AM":position==29?"AM":position==30?"AM":position==31?"AM":position==32?"AM":position==33?"AM":position==34?"AM":position==35?"AM":position==36?"AM":position==37?"AM":position==38?"AM":position==39?"AM":position==40?"AM":position==41?"AM":position==42?"AM":position==43?"AM":position==44?"AM":position==45?"AM":position==46?"AM":position==47?"AM":position==48?"AM":position==49?"AM":position==50?"AM":position==51?"AM":position==52?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":position==11?"AM":"GH");
                //Toast.makeText(getActivity(),forecast,Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, forecast). putExtra(Intent.EXTRA_EMAIL, CountryID).putExtra("XYZ",continent).putExtra("Currency",currency).putExtra("PhoneCode",phoneCode);


                startActivity(intent1);
            }
        });

        return rootView;

    }

    public class FetchWeatherTask extends AsyncTask<String, String[], String[]> {
        //private static final String QUERY_PARAM = "q" ;
        //private static final String APPID = "appid" ;
        public String[] NewString = new String[1000];
        private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();

        @Override
        protected String[] doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String forecastJsonstr = null;
            try {


                String baseUrl = "http://country.io/names.json";
                //String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?";
                //Uri uribuild = Uri.parse(baseUrl).buildUpon().appendQueryParameter(QUERY_PARAM,params[0]).appendQueryParameter(APPID,"8940f8f60b35d18449c789d2741f25da").build();

                URL url = new URL(baseUrl.toString());
                Log.v(LOG_TAG, "BUILT URI" + baseUrl.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //Toast.makeText(getActivity(),(String)baseUrl,Toast.LENGTH_LONG).show();
                System.out.print(urlConnection.getResponseCode());
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                forecastJsonstr = buffer.toString();
                //String[] Result = getWeatherDataFromJson(forecastJsonstr ,4);
                String[] Json1 = forecastJsonstr.split("[A-Z][A-Z]");
                NewString = new String[Json1.length];

                Log.v(LOG_TAG, "ForeCastJson String" + forecastJsonstr);

                for (int i = 0; i < Json1.length; i++) {
                    NewString[i] = Json1[i].replaceAll("[{}\":,]","");

                    Log.v(LOG_TAG, "Json " + NewString[i] + "\n");
                }


            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "error closing stream", e);

                    }
                }
            }
            
            for (int i = 0; i < NewString.length; i++)
            {
                for (int j = i + 1; j < NewString.length; j++)
                {
                    if (NewString[i].compareTo(NewString[j])>0)
                    {
                        String temp = NewString[i];
                        NewString[i] = NewString[j];
                        NewString[j] = temp;
                    }
                }
            }

            return NewString;


        }

        @Override
        protected void onPostExecute(String[] result) {
            if (result != null) {
                mForecastadapter.clear();
                for(int i =1;i<result.length;i++){
                    result[i-1] = result[i];
                }
                for (String NewString : result) {
                    Log.v(LOG_TAG, "result " + NewString);
                    mForecastadapter.add(NewString);

                }


            }


        }


    }
    public class Newclass extends AsyncTask<String, String, String> {
        //private static final String QUERY_PARAM = "q" ;
        //private static final String APPID = "appid" ;
        public String NewString = new String();
        private final String LOG_TAG = Newclass.class.getSimpleName();

        @Override
        protected String doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String forecastJsonstr = null;
            try {


                String baseUrl = "http://country.io/names.json";
                //String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?";
                //Uri uribuild = Uri.parse(baseUrl).buildUpon().appendQueryParameter(QUERY_PARAM,params[0]).appendQueryParameter(APPID,"8940f8f60b35d18449c789d2741f25da").build();

                URL url = new URL(baseUrl.toString());
                Log.v(LOG_TAG, "BUILT URI" + baseUrl.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //Toast.makeText(getActivity(),(String)baseUrl,Toast.LENGTH_LONG).show();
                System.out.print(urlConnection.getResponseCode());
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                forecastJsonstr = buffer.toString();
                //String[] Result = getWeatherDataFromJson(forecastJsonstr ,4);

                NewString = new String(forecastJsonstr);

                Log.v(LOG_TAG, "ForeCastJson String" + NewString);






            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "error closing stream", e);

                    }
                }
            }


            return NewString;


        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {


                String NewString = new String(result);
                    Log.v(LOG_TAG, "result " + NewString);
                    newstr = new String(NewString);

                }


            }


        }
    public class Continent_class extends AsyncTask<String, String, String> {
        //private static final String QUERY_PARAM = "q" ;
        //private static final String APPID = "appid" ;
        public String NewString = new String();
        private final String LOG_TAG = Newclass.class.getSimpleName();

        @Override
        protected String doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String forecastJsonstr = null;
            try {


                String baseUrl = "http://country.io/continent.json";
                //String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?";
                //Uri uribuild = Uri.parse(baseUrl).buildUpon().appendQueryParameter(QUERY_PARAM,params[0]).appendQueryParameter(APPID,"8940f8f60b35d18449c789d2741f25da").build();

                URL url = new URL(baseUrl.toString());
                Log.v(LOG_TAG, "BUILT URI" + baseUrl.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //Toast.makeText(getActivity(),(String)baseUrl,Toast.LENGTH_LONG).show();
                System.out.print(urlConnection.getResponseCode());
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                forecastJsonstr = buffer.toString();
                //String[] Result = getWeatherDataFromJson(forecastJsonstr ,4);

                NewString = new String(forecastJsonstr);

                Log.v(LOG_TAG, "ForeCastJson String" + NewString);






            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "error closing stream", e);

                    }
                }
            }


            return NewString;


        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {


                String NewString = new String(result);
                Log.v(LOG_TAG, "result " + NewString);
                continent = new String(NewString);

            }


        }


    }
    public class Currency extends AsyncTask<String, String, String> {
        //private static final String QUERY_PARAM = "q" ;
        //private static final String APPID = "appid" ;
        public String NewString = new String();
        private final String LOG_TAG = Newclass.class.getSimpleName();

        @Override
        protected String doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String forecastJsonstr = null;
            try {


                String baseUrl = "http://country.io/currency.json";
                //String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?";
                //Uri uribuild = Uri.parse(baseUrl).buildUpon().appendQueryParameter(QUERY_PARAM,params[0]).appendQueryParameter(APPID,"8940f8f60b35d18449c789d2741f25da").build();

                URL url = new URL(baseUrl.toString());
                Log.v(LOG_TAG, "BUILT URI" + baseUrl.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //Toast.makeText(getActivity(),(String)baseUrl,Toast.LENGTH_LONG).show();
                System.out.print(urlConnection.getResponseCode());
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                forecastJsonstr = buffer.toString();
                //String[] Result = getWeatherDataFromJson(forecastJsonstr ,4);

                NewString = new String(forecastJsonstr);

                Log.v(LOG_TAG, "ForeCastJson String" + NewString);






            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "error closing stream", e);

                    }
                }
            }


            return NewString;


        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {


                String NewString = new String(result);
                Log.v(LOG_TAG, "result " + NewString);
                currency = new String(NewString);

            }


        }


    }
    public class phonecode extends AsyncTask<String, String, String> {
        //private static final String QUERY_PARAM = "q" ;
        //private static final String APPID = "appid" ;
        public String NewString = new String();
        private final String LOG_TAG = Newclass.class.getSimpleName();

        @Override
        protected String doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String forecastJsonstr = null;
            try {


                String baseUrl = "http://country.io/phone.json";
                //String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?";
                //Uri uribuild = Uri.parse(baseUrl).buildUpon().appendQueryParameter(QUERY_PARAM,params[0]).appendQueryParameter(APPID,"8940f8f60b35d18449c789d2741f25da").build();

                URL url = new URL(baseUrl.toString());
                Log.v(LOG_TAG, "BUILT URI" + baseUrl.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                //Toast.makeText(getActivity(),(String)baseUrl,Toast.LENGTH_LONG).show();
                System.out.print(urlConnection.getResponseCode());
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                forecastJsonstr = buffer.toString();
                //String[] Result = getWeatherDataFromJson(forecastJsonstr ,4);

                NewString = new String(forecastJsonstr);

                Log.v(LOG_TAG, "ForeCastJson String" + NewString);






            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "error closing stream", e);

                    }
                }
            }


            return NewString;


        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {


                String NewString = new String(result);
                Log.v(LOG_TAG, "result " + NewString);
                phoneCode= new String(NewString);

            }


        }


    }


    }




