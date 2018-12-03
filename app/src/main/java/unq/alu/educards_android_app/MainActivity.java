package unq.alu.educards_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import educards.educards_model.EducardsFactory;
import educards.educards_model.Player;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    Player p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText playerName = findViewById(R.id.editTextUsernameLogin);
        final EditText playerPassword = findViewById(R.id.editTextPasswordLogin);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EducardsFactory().getServiceFactory().getPlayer(playerName.getText().toString(),playerPassword.getText().toString(), new Callback<Player>() {
                    @Override
                    public void success(Player response, Response response2) {
                        p = (Player)response;
                        Intent startIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startIntent.putExtra("id",p.getId());
                        startIntent.putExtra("name", p.getUsername());
                        startIntent.putExtra("image", p.getImage() );
                        startIntent.putExtra("password", p.getPassword());
                        startIntent.putExtra("age", p.getAge());

                        startActivity(startIntent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getBaseContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        Button registerButtonLogin = findViewById(R.id.registerButtonLogin);
        registerButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                registerIntent.putExtra("extra", playerName.getText().toString());
                startActivity(registerIntent);
            }
        });
    }
}