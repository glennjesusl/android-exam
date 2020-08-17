package com.glim.upraxisexam.Activities;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.glim.upraxisexam.Models.DetailModel;
import com.glim.upraxisexam.R;
import com.glim.upraxisexam.Retrofit.ApiClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private String urlToLoad = "";
    private TextView tvName, tvBirthDate, tvEmail, tvAddress,
            tvPhoneNumber, tvContactPerson, tvContactsNumber;
    private ImageView ivProfileImage;
    private ApiClient apiClient = ApiClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle =  getIntent().getExtras();
        urlToLoad = bundle.getString("urlToLoad");
        System.out.println("urlToLoad(received): "+urlToLoad);

        initViews();
        getDetailsData(urlToLoad);
    }

    private void initViews(){

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvName = findViewById(R.id.tvName);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvContactPerson = findViewById(R.id.tvContactPerson);
        tvContactsNumber = findViewById(R.id.tvContactsNumber);

    }

    private void getDetailsData(String url){

        Call<DetailModel> call = apiClient.getApi().getDetails(url);
        call.enqueue(new Callback<DetailModel>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {

                if (response.isSuccessful()) {

                    System.out.println("Detail Response Body: " + response.body());
                    try {
                        displayDetails(response.body());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(DetailsActivity.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DetailModel> call, Throwable t) {
                System.out.println("FAILED TO RETRIEVED DATA: " + t.getMessage());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void displayDetails(DetailModel data) throws ParseException {

        System.out.printf("Difference :"+calcYearsDifference("1982-03-13"));

        //ivProfileImage.setImageS(data.getData().get(0).getProfileImage());
        Glide.with(this).load(data.getData().get(0).getProfileImage()).into(ivProfileImage);
        tvName.setText(data.getData().get(0).getLastName()+", "+data.getData().get(0).getFirstName());
        tvBirthDate.setText(formatDate(data.getData().get(0).getBirthDate())+" ("+calcYearsDifference(data.getData().get(0).getBirthDate())+" Y.O.)");
        tvEmail.setText(data.getData().get(0).getEmail());
        tvAddress.setText(data.getData().get(0).getAddress().getSuite()+"\n"+data.getData().get(0).getAddress().getStreet()+"\n"
                +data.getData().get(0).getAddress().getCity()+","+data.getData().get(0).getAddress().getZipcode());
        tvPhoneNumber.setText(data.getData().get(0).getPhoneNumber());
        tvContactPerson.setText(data.getData().get(0).getContactsName());
        tvContactsNumber.setText(data.getData().get(0).getContactsNumber());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String calcYearsDifference(String birthDate){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String currDate = simpleDateFormat.format(new Date());

        // create date instances
        LocalDate localDate1 = LocalDate.parse(birthDate);
        LocalDate localDate2 = LocalDate.parse(currDate);

        // calculate difference
        long years = Period.between(localDate1, localDate2).getYears();

        // print days
        System.out.println("Years between " + localDate1 + " and " + localDate2 + ": " + years);

        return String.valueOf(years);
    }

    private String formatDate(String strDate) throws ParseException {

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = strDate;

        Date date = formatter1.parse(dateInString);
        System.out.println(date);
        System.out.println(formatter2.format(date));

        return formatter2.format(date);

    }

}