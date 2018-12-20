package dsa.eetac.upc.edu.exampleminim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import dsa.eetac.upc.edu.exampleminim2.githubAPI.gitApiService;
import dsa.eetac.upc.edu.exampleminim2.models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exploreFollowersClick(View view){
        EditText editTextusername = (EditText) findViewById(R.id.editText);
        String username = editTextusername.getText().toString();
        Intent i = new Intent(this,ListActivity.class);
        i.putExtra(EXTRA_MESSAGE,username);
        startActivity(i);
    }
}
