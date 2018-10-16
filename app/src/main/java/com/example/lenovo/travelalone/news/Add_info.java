package com.example.lenovo.travelalone.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.lenovo.travelalone.R;

public class Add_info extends AppCompatActivity {

    EditText Name,Email,Phone;
    String name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        Name=findViewById(R.id.name);
        Email=findViewById(R.id.email);
        Phone=findViewById(R.id.phone);
    }

    public  void saveinfo(View view){
        name=Name.getText().toString();
        email=Email.getText().toString();
        phone=Phone.getText().toString();
        //Backgroundtask backgroundtask=new Backgroundtask();
        //backgroundtask.execute(name,email,phone);
        finish();

    }
/*
    class Backgroundtask extends AsyncTask<String,Void,String>{

        String addinfourl;


        @Override
        protected void onPreExecute() {
            addinfourl="https://limy-masks.000webhostapp.com/addinfo.php";

        }

        @Override
        protected String doInBackground(String... args) {
            String name,email,phone;
            name=args[0];
            email=args[1];
            phone=args[2];
            try {
                URL url=new URL(addinfourl);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String datastring= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8");
                bufferedWriter.write(datastring);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "one Row of data inserted";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(Add_info.this, result, Toast.LENGTH_SHORT).show();
        }
    }
*/
}
