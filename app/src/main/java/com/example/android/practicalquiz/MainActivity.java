package com.example.android.practicalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTopToolbar;

    private EditText mUserNameEditText = findViewById(R.id.username);
    private EditText mEmailEditText = findViewById(R.id.email);
    private EditText mDescriptionEditText = findViewById(R.id.content);

    public static final String STATE_USER = "username";
    public static final String STATE_EMAIL = "email";
    public static final String STATE_CONTENT = "content";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_next) {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        if(savedInstanceState != null) {
            mUserNameEditText.setText(savedInstanceState.getString(STATE_USER));
            mEmailEditText.setText(savedInstanceState.getString(STATE_EMAIL));
            mDescriptionEditText.setText(savedInstanceState.getString(STATE_CONTENT));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String username = mUserNameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();
        String content = mDescriptionEditText.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(STATE_USER, username);
        bundle.putString(STATE_EMAIL, email);
        bundle.putString(STATE_CONTENT, content);
        super.onSaveInstanceState(outState);
    }
}
