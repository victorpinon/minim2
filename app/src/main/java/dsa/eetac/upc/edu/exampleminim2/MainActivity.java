package dsa.eetac.upc.edu.exampleminim2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import java.util.List;

import dsa.eetac.upc.edu.exampleminim2.DibaAPI.DibaAPI;
import dsa.eetac.upc.edu.exampleminim2.models.Cities;
import dsa.eetac.upc.edu.exampleminim2.models.Element;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CitiesRecyclerViewAdapter recycler;
    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    private DibaAPI dibaAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recycler = new CitiesRecyclerViewAdapter(this);
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dibaAPI = DibaAPI.createAPIRest();

        getCities();
    }

    private void getCities() {

        progressBar.setVisibility(ProgressBar.VISIBLE);

        Call<Cities> callCitiesList = dibaAPI.cities(1,11);
        callCitiesList.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {

                if (response.isSuccessful()) {
                    Cities cities = response.body();
                    List<Element> listElements = cities.getElements();
                    recycler.addElements(listElements);
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                } else {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("Error: la api esta fallant");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //dismiss the dialog
                        }
                    });
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                }
            }
            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("Error: no tens acces a internet");
                dlgAlert.setTitle("Error");
                dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }

        });

    }
}
