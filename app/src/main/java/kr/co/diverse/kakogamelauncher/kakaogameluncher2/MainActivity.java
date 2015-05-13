package kr.co.diverse.kakogamelauncher.kakaogameluncher2;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import net.daum.adam.publisher.impl.AdError;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import net.daum.adam.publisher.AdView;
import net.daum.adam.publisher.AdView.*;
import net.daum.adam.publisher.impl.AdError;

public class MainActivity extends ActionBarActivity {
    String shells;
    String account1name;
    String account2name;
    String account3name;
    String account4name;
    String account5name;
    String account6name;
    String account7name;
    String account8name;
    String account9name;
    ProgressBar mProgCircle;
    private static final String LOGTAG = "BannerTypeXML1";
    private net.daum.adam.publisher.AdView adView = null;
    private final long	FINSH_INTERVAL_TIME    = 2000;
    private long		backPressedTime        = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //initAdam();
        com.google.android.gms.ads.AdView ad2 = (com.google.android.gms.ads.AdView) findViewById(R.id.adView2);     //위에 xml id를 adView라고 똑같이 했을 경우입니다.
        AdRequest adRequest2 = new AdRequest.Builder()
 /*.addTestDevice("장치 고유 ID")*/      // Test 장치로 바로 광고가 보이는 것을 확인하고 싶을때 사용
                .build();
        ad2.loadAd(adRequest2);

        mProgCircle = (ProgressBar) findViewById(R.id.progressBar);
        mProgCircle.setVisibility(View.VISIBLE);

        SharedPreferences account1 = getSharedPreferences("accountname", MODE_PRIVATE);
        account1name = account1.getString("name1", "");
        final Button button1 = (Button) findViewById(R.id.button1);
        if (account1name != "") {
            button1.setText(account1name);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "1");
                editor.commit();
                if (account1name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("1");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account2 = getSharedPreferences("accountname", MODE_PRIVATE);
        account2name = account2.getString("name2", "");
        final Button button2 = (Button) findViewById(R.id.button2);
        if (account2name != "") {
            button2.setText(account2name);
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "2");
                editor.commit();
                if (account2name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("2");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account3 = getSharedPreferences("accountname", MODE_PRIVATE);
        account3name = account3.getString("name3", "");
        final Button button3 = (Button) findViewById(R.id.button3);
        if (account3name != "") {
            button3.setText(account3name);
        }
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "3");
                editor.commit();
                if (account3name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("3");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account4 = getSharedPreferences("accountname", MODE_PRIVATE);
        account4name = account4.getString("name4", "");
        final Button button4 = (Button) findViewById(R.id.button4);
        if (account4name != "") {
            button4.setText(account4name);
        }
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "4");
                editor.commit();
                if (account4name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("4");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account5 = getSharedPreferences("accountname", MODE_PRIVATE);
        account5name = account5.getString("name5", "");
        final Button button5 = (Button) findViewById(R.id.button5);
        if (account5name != "") {
            button5.setText(account5name);
        }
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "5");
                editor.commit();
                if (account5name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("5");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account6 = getSharedPreferences("accountname", MODE_PRIVATE);
        account6name = account6.getString("name6", "");
        final Button button6 = (Button) findViewById(R.id.button6);
        if (account6name != "") {
            button6.setText(account6name);
        }
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "6");
                editor.commit();
                if (account6name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("6");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account7 = getSharedPreferences("accountname", MODE_PRIVATE);
        account7name = account7.getString("name7", "");
        final Button button7 = (Button) findViewById(R.id.button7);
        if (account7name != "") {
            button7.setText(account7name);
        }
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "7");
                editor.commit();
                if (account7name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("7");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account8 = getSharedPreferences("accountname", MODE_PRIVATE);
        account8name = account8.getString("name8", "");
        final Button button8 = (Button) findViewById(R.id.button8);
        if (account8name != "") {
            button8.setText(account8name);
        }
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "8");
                editor.commit();
                if (account8name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("8");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });
        SharedPreferences account9 = getSharedPreferences("accountname", MODE_PRIVATE);
        account9name = account9.getString("name9", "");
        final Button button9 = (Button) findViewById(R.id.button9);
        if (account9name != "") {
            button9.setText(account9name);
        }
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("check", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("check", "9");
                editor.commit();
                if (account9name != "") {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
                    alertDlg.setTitle(R.string.alert_title_question);
                    // '예' 버튼이 클릭되면
                    alertDlg.setPositiveButton( R.string.button_yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            qwer("9");
                        }
                    });
                    // '아니오' 버튼이 클릭되면
                    alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    // alertDlg.setMessage( String.format( getString(R.string.alert_msg_delete),list.get(position)) );
                    alertDlg.show();
                } else {
                    Intent intentSubActivity = new Intent(getApplication(), login.class);
                    startActivity(intentSubActivity);
                    finish();
                }
            }
        });

        new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
            @Override
            public void run() {

                Random generator = new Random();
                int num1 = generator.nextInt(10) + 1;

                if (num1 == 1) {
                    randomm();
                }
                if (num1 == 2) {
                    randomm();
                }
                if (num1 == 3) {
                    randomm();
                }
                if (num1 == 4) {
                    randomm();
                }
                else {
                    try {
                        BufferedReader reader = null;
                        Process p = Runtime.getRuntime().exec("su");
                        DataOutputStream os = new DataOutputStream(p.getOutputStream());
                        reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        os.writeBytes("su");
                        os.flush();
                    } catch (IOException e) {
                    }
                }
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                mProgCircle.setVisibility(View.INVISIBLE);
            }
        }, 2500);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            accountdel("name1");
            return true;
        }
        if (id == R.id.action_2) {
            accountdel("name2");
            return true;
        }
        if (id == R.id.action_3) {
            accountdel("name3");
            return true;
        }
        if (id == R.id.action_4) {
            accountdel("name4");
            return true;
        }
        if (id == R.id.action_5) {
            accountdel("name5");
            return true;
        }
        if (id == R.id.action_6) {
            accountdel("name6");
            return true;
        }
        if (id == R.id.action_7) {
            accountdel("name7");
            return true;
        }
        if (id == R.id.action_8) {
            accountdel("name8");
            return true;
        }
        if (id == R.id.action_9) {
            accountdel("name9");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void qwer(String sstr1) {

        SharedPreferences account1 = getSharedPreferences("accountname", MODE_PRIVATE);
        String check2 = account1.getString("namee" + sstr1, "");

        if (check2.contains("마블")){
            BufferedReader reader = null;
            try {
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.cjenm.ModooMarbleKakao");
                Process p = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(p.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                os.writeBytes("rm -rf /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/channel.kakao.xml\n" +
                        "rm -rf /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/marblePush.ko_kr.xml\n" +
                        "rm -rf /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/adpopcorn_parameter.xml\n" +
                        "rm -rf /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/" +
                        "cp /data/data/kr.co.diverse.kakogamelauncher.kakaogameluncher2/shared_prefs/account" + sstr1 + ".xml /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/channel.kakao.xml\n" +
                        "chmod 777 /data/data/com.cjenm.ModooMarbleKakao/shared_prefs/channel.kakao.xml");
                os.flush();
                //String path = "/data/data/com.cjenm.ModooMarbleKakao/shared_prefs/";
                //File file = new File(path + "/channel.kakao.xml");
                Toast.makeText(getApplication(), "게임실행중...", Toast.LENGTH_LONG).show();
                mProgCircle.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                    @Override
                    public void run() {
                        // 실행할 동작 코딩
                        mProgCircle.setVisibility(View.INVISIBLE);
                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        am.killBackgroundProcesses("com.cjenm.ModooMarbleKakao");

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.cjenm.ModooMarbleKakao");
                        startActivity(launchIntent);
                        Toast.makeText(getApplication(), "꼭! 약관이 뜰 시 게임종료 후 재시작 해주세요\n" +
                                "(2번정도 재시작 해야합니다.)", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplication(), "꼭! 약관이 뜰 시 게임종료 후 재시작 해주세요\n" +
                                "(2번정도 재시작 해야합니다.)", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplication(), "꼭! 약관이 뜰 시 게임종료 후 재시작 해주세요\n" +
                                "(2번정도 재시작 해야합니다.)", Toast.LENGTH_LONG).show();
                    }
                }, 2000);
            } catch (IOException e) {
                Toast.makeText(getApplication(), "게임실행실패...", Toast.LENGTH_LONG).show();
            }
        }
        if (check2.contains("세븐")){
            BufferedReader reader = null;
            try {
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.cjenm.sknights");
                Process p = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(p.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                os.writeBytes("rm -rf /data/data/com.cjenm.sknights/shared_prefs/channel.kakao.xml\n" +
                        "cp /data/data/kr.co.diverse.kakogamelauncher.kakaogameluncher2/shared_prefs/account" + sstr1 + ".xml /data/data/com.cjenm.sknights/shared_prefs/channel.kakao.xml\n" +
                        "chmod 777 /data/data/com.cjenm.sknights/shared_prefs/channel.kakao.xml");
                os.flush();
                //String path = "/data/data/com.cjenm.ModooMarbleKakao/shared_prefs/";
                //File file = new File(path + "/channel.kakao.xml");
                Toast.makeText(getApplication(), "게임실행중...", Toast.LENGTH_LONG).show();
                mProgCircle.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                    @Override
                    public void run() {
                        // 실행할 동작 코딩
                        mProgCircle.setVisibility(View.INVISIBLE);
                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        am.killBackgroundProcesses("com.cjenm.sknights");

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.cjenm.sknights");
                        startActivity(launchIntent);
                    }
                }, 2000);
            } catch (IOException e) {
                Toast.makeText(getApplication(), "게임실행실패...", Toast.LENGTH_LONG).show();
            }
        }
        if (check2.contains("쿠키")){
            BufferedReader reader = null;
            try {
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.devsisters.CookieRunForKakao");
                Process p = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(p.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                os.writeBytes("rm -rf /data/data/com.devsisters.CookieRunForKakao/shared_prefsdevsisters.kakao.auth.pref.key.xml\n" +
                        "cp /data/data/kr.co.diverse.kakogamelauncher.kakaogameluncher2/shared_prefs/account" + sstr1 + ".xml /data/data/com.devsisters.CookieRunForKakao/shared_prefs/devsisters.kakao.auth.pref.key.xml\n" +
                        "chmod 777 /data/data/com.cjenm.sknights/shared_prefs/kakaoPreference.xml");
                os.flush();
                //String path = "/data/data/com.cjenm.ModooMarbleKakao/shared_prefs/";
                //File file = new File(path + "/channel.kakao.xml");
                Toast.makeText(getApplication(), "게임실행중...", Toast.LENGTH_LONG).show();
                mProgCircle.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                    @Override
                    public void run() {
                        // 실행할 동작 코딩
                        mProgCircle.setVisibility(View.INVISIBLE);
                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        am.killBackgroundProcesses("com.devsisters.CookieRunForKakao");

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.devsisters.CookieRunForKakao");
                        startActivity(launchIntent);
                    }
                }, 2000);
            } catch (IOException e) {
                Toast.makeText(getApplication(), "게임실행실패...", Toast.LENGTH_LONG).show();
            }
        }
        if (check2.contains("몬스터")){
            BufferedReader reader = null;
            try {
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.cjenm.monster");
                Process p = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(p.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                os.writeBytes("rm -rf /data/data/com.cjenm.monster/shared_prefschannel.kakao.xml\n" +
                        "cp /data/data/kr.co.diverse.kakogamelauncher.kakaogameluncher2/shared_prefs/account" + sstr1 + ".xml /data/data/com.cjenm.monster/shared_prefs/channel.kakao.xml\n" +
                        "chmod 777 /data/data/com.cjenm.monster/shared_prefs/channel.kakao.xml");
                os.flush();
                //String path = "/data/data/com.cjenm.ModooMarbleKakao/shared_prefs/";
                //File file = new File(path + "/channel.kakao.xml");
                Toast.makeText(getApplication(), "게임실행중...", Toast.LENGTH_LONG).show();
                mProgCircle.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                    @Override
                    public void run() {
                        // 실행할 동작 코딩
                        mProgCircle.setVisibility(View.INVISIBLE);
                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        am.killBackgroundProcesses("com.cjenm.monster");

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.cjenm.monster");
                        startActivity(launchIntent);
                    }
                }, 2000);
            } catch (IOException e) {
                Toast.makeText(getApplication(), "게임실행실패...", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplication(), check2, Toast.LENGTH_LONG).show();
        }
    }
    public void accountdel(String sstr1) {
        SharedPreferences prefs1 = getSharedPreferences("accountname", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = prefs1.edit();
        editor1.putString(sstr1, "");
        editor1.commit();
        Intent intentSubActivity = new Intent( this, MainActivity.class );
        startActivity( intentSubActivity );
        finish();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (adView != null) {
            adView.destroy();
            adView = null;
        }
    }


    private void initAdam() {
        // AdFit(Ad@m) sdk 초기화 시작
        adView = (net.daum.adam.publisher.AdView) findViewById(R.id.adview1);
        // 광고 리스너 설정
        // 1. 광고 클릭시 실행할 리스너
        adView.setOnAdClickedListener(new OnAdClickedListener() {
            @Override
            public void OnAdClicked() {
                Log.i(LOGTAG, "광고를 클릭했습니다.");
            }
        });
        // 2. 광고 내려받기 실패했을 경우에 실행할 리스너
        adView.setOnAdFailedListener(new OnAdFailedListener() {
            @Override
            public void OnAdFailed(AdError error, String message) {
                Log.w(LOGTAG, message);
            }
        });
        // 3. 광고를 정상적으로 내려받았을 경우에 실행할 리스너
        adView.setOnAdLoadedListener(new OnAdLoadedListener() {
            @Override
            public void OnAdLoaded() {
                Log.i(LOGTAG, "광고가 정상적으로 로딩되었습니다.");
            }
        });
        // 4. 광고를 불러올때 실행할 리스너
        adView.setOnAdWillLoadListener(new OnAdWillLoadListener() {
            @Override
            public void OnAdWillLoad(String url) {
                Log.i(LOGTAG, "광고를 불러옵니다. : " + url);
            }
        });
        // 5. 전면형 광고를 닫았을때 실행할 리스너
        adView.setOnAdClosedListener(new OnAdClosedListener() {
            @Override
            public void OnAdClosed() {
                Log.i(LOGTAG, "광고를 닫았습니다.");
            }
        });
        // 할당 받은 광고단위ID 설정
        // adView.setClientId(“광고단위ID”);
        // 광고 갱신 주기를 12초로 설정
        // adView.setRequestInterval(12);
        // 광고 영역에 캐시 사용 여부 : 기본 값은 true
        adView.setAdCache(false);
        // Animation 효과 : 기본 값은 AnimationType.NONE
        adView.setAnimationType(AnimationType.FLIP_HORIZONTAL);
        adView.setVisibility(View.VISIBLE);
    }
    @Override
     public void onBackPressed() {
        long tempTime        = System.currentTimeMillis();
        long intervalTime    = tempTime - backPressedTime;

        if ( 0 <= intervalTime && FINSH_INTERVAL_TIME >= intervalTime ) {
            super.onBackPressed();

        }
        else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(),"'뒤로'버튼을한번더누르시면종료됩니다.",Toast.LENGTH_SHORT).show();
        }
     }

    public void randomm(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;

        if(deviceWidth == 1080){
            shells = "input tap 545 324";
        }
        if(deviceWidth == 480){
            shells = "input tap 242 144";
        }
        if(deviceWidth == 320){
            shells = "input tap 161 96";
        }
        if(deviceWidth == 720){
            shells = "input tap 363 216";
        }
        if(deviceWidth == 768){
            shells = "input tap 387 230";
        }
        if(deviceWidth == 800){
            shells = "input tap 403 240";
        }
        if(deviceWidth == 1200){
            shells = "input tap 605 360";
        }
        if(deviceWidth == 1440){
            shells = "input tap 726 432";
        }
        if(deviceWidth == 1600){
            shells = "input tap 807 480";
        }
        else{
            shells = "input tap 545 324";
        }
        try
        {
            BufferedReader reader = null;
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //os.writeBytes(shells + "\n" + shells);
            os.flush();
        }catch (IOException e)
        {
        }
    }
}
