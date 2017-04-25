package lecture.mobile.minsky.multipageapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
    }

    public void myListener(View target) {
//        Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
//        startActivity(intent);

        Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
        startActivityForResult(intent, GET_STRING);
    }

    public void myListener1(View target) {
        Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
        startActivity(intent);
    }

    public void myListener2(View target) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_STRING) {
            if(resultCode == RESULT_OK) {
                String answer = data.getStringExtra("INPUT_TEXT");
                Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
                text.setText(answer);
            }
        }
    }

    public void handleImplicit(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.callButton:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)12345789"));
                break;
            case R.id.mapButton:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.30,127.2?z=10"));
                break;
        }

        if(intent != null)
            startActivity(intent);
    }
}
