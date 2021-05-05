package com.example.form;


import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RatingBar;
        import android.widget.Toast;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_bar);
        // initiate rating bar and a button
        final RatingBar simpleRatingBar = (RatingBar)
                findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) findViewById
                (R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get values and then displayed in a toast
                        String totalStars = "Total Stars:: " +
                                simpleRatingBar.getNumStars();
                        String rating = "Rating :: " +
                                simpleRatingBar.getRating();
                        Toast.makeText(getApplicationContext(), totalStars
                                + "\n" +
                                rating, Toast.LENGTH_LONG).show();
                    }
                });
    }
}