package kr.co.diverse.kakogamelauncher.kakaogameluncher2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;


public class login extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> arraylist;
    String sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        arraylist = new ArrayList<String>();
        arraylist.add("선택해주세요");
        arraylist.add("모두의 마블");
        arraylist.add("세븐 나이츠");
        arraylist.add("쿠키런");
        arraylist.add("몬스터 길들이기");



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arraylist);
        //스피너 속성
        Spinner sp = (Spinner) this.findViewById(R.id.spinner);
        sp.setPrompt("골라봐"); // 스피너 제목
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);


        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                SharedPreferences account1 = getSharedPreferences("check", MODE_PRIVATE);
                String check = account1.getString("check", "");

                try
                {
                    qwer(check);
                    Toast.makeText(getApplication(), "로그인성공", Toast.LENGTH_SHORT).show();

                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //ActivityEx01.class 불러오기 위해
                    startActivity(intent);
                }catch (Exception e)
                {
                    Toast.makeText(getApplication(), "아이디 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        //
        //Toast.makeText(this, arraylist.get(arg2), Toast.LENGTH_LONG).show();//해당목차눌렸을때
        SharedPreferences account1 = getSharedPreferences("check", MODE_PRIVATE);
        String check = account1.getString("check", "");

        SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = prefs1.edit();
        editor1.putString("namee" + check, arraylist.get(arg2));
        editor1.commit();

    }


    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void posthttp(String sstr1) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost();
            post.setURI(new URI(sstr1));
            HttpResponse resp = client.execute(post);
            BufferedReader br = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            String str = null;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
            br.close();
            sub2 = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void qwer(String sstr1) {
        EditText id;
        id = (EditText) findViewById(R.id.editText);
        String idstr = id.getText().toString();

        EditText pass;
        pass = (EditText) findViewById(R.id.editText2);
        String passstr = pass.getText().toString();

        SharedPreferences account1 = getSharedPreferences("accountname", MODE_PRIVATE);
        String check2 = account1.getString("namee" + sstr1, "");

        if (check2.contains("마블")){
            String aa = "https://auth.kakao.com/oauth/token?username=" + idstr + "&password=" + passstr + "&client_id=89183114982564704&client_secret=4TcyiK3HxCrOjaC86bOArXRq48X1RruxuMHrEkfsWlB6bJLxSI0i0CiqfmHK3xUa7BeELGg4PNZ2bZIuCBj%2Fjg%3D%3D&grant_type=password";
            posthttp(aa);
            String[] access_token = sub2.split("access_token\":\"");
            String[] access_token2 = access_token[1].split("\",");

            String[] refresh_token = sub2.split("refresh_token\":\"");
            String[] refresh_token2 = refresh_token[1].split("\",");

            SharedPreferences prefs = getSharedPreferences("account" + sstr1, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = prefs1.edit();


            editor1.putString("name" + sstr1, check2 + " - 아이디:" + idstr);
            editor.putString("access_token", access_token2[0]);
            editor.putString("refresh_token", refresh_token2[0]);
            editor.commit();
            editor1.commit();
        }
        if (check2.contains("세븐")){
            String aa = "https://auth.kakao.com/oauth/token?username=" + idstr + "&password=" + passstr + "&client_id=90791709927640224&client_secret=rhRepZOOuPntkwF3XmJ2cHMgaCBwj5Vx%2B%2BFSf0ErXODORV3kfsuWCS5NGAvCx2M1qnp3FfwampUsr0W%2FjD58Ag%3D%3D&grant_type=password";
            posthttp(aa);
            String[] access_token = sub2.split("access_token\":\"");
            String[] access_token2 = access_token[1].split("\",");

            String[] refresh_token = sub2.split("refresh_token\":\"");
            String[] refresh_token2 = refresh_token[1].split("\",");

            SharedPreferences prefs = getSharedPreferences("account" + sstr1, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = prefs1.edit();


            editor1.putString("name" + sstr1, check2 + " - 아이디:" + idstr);
            editor.putString("access_token", access_token2[0]);
            editor.putString("refresh_token", refresh_token2[0]);
            editor.commit();
            editor1.commit();
        }
        if (check2.contains("쿠키")){
            String aa = "https://auth.kakao.com/oauth/token?username=" + idstr + "&password=" + passstr + "&client_id=88888119456295617&client_secret=GSNoUCgkp1S5EptXRL7bmfTuqSCCUcFRidP7qP7lG3QUtP6VS4RzPrSpQLFigA44i%2BSztEA3hAhxYiAxZ%2FkUyQ%3D%3D&grant_type=password";
            posthttp(aa);
            String[] access_token = sub2.split("access_token\":\"");
            String[] access_token2 = access_token[1].split("\",");

            String[] refresh_token = sub2.split("refresh_token\":\"");
            String[] refresh_token2 = refresh_token[1].split("\",");

            SharedPreferences prefs = getSharedPreferences("account" + sstr1, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = prefs1.edit();


            editor1.putString("name" + sstr1, check2 + " - 아이디:" + idstr);
            editor.putString("access_token", access_token2[0]);
            editor.putString("refresh_token", refresh_token2[0]);
            editor.commit();
            editor1.commit();
        }
        if (check2.contains("몬스터")){
            String aa = "https://auth.kakao.com/oauth/token?username=" + idstr + "&password=" + passstr + "&client_id=89641336900131600&client_secret=a48qTnNokxU%2FBYNdjQf2WgL6ofXLN5f5mpz90bMA3Y%2BTovL%2FPnbPSWJSulqVtOg74i6%2F4n6T%2FSHVHPgw54rjIw%3D%3D&grant_type=password";
            posthttp(aa);
            String[] access_token = sub2.split("access_token\":\"");
            String[] access_token2 = access_token[1].split("\",");

            String[] refresh_token = sub2.split("refresh_token\":\"");
            String[] refresh_token2 = refresh_token[1].split("\",");

            SharedPreferences prefs = getSharedPreferences("account" + sstr1, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = prefs1.edit();


            editor1.putString("name" + sstr1, check2 + " - 아이디:" + idstr);
            editor.putString("access_token", access_token2[0]);
            editor.putString("refresh_token", refresh_token2[0]);
            editor.commit();
            editor1.commit();
        }
        //Toast.makeText(getApplication(), sub2, Toast.LENGTH_LONG).show();
    }
}
