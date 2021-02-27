package com.google.developers.teapot.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.developers.teapot.R;
import com.google.developers.teapot.data.Tea;
import com.google.developers.teapot.ui.SettingActivity;
import com.google.developers.teapot.ui.add.AddTeaActivity;
import com.google.developers.teapot.ui.list.TeaListActivity;
import com.google.developers.teapot.ui.timer.TimerActivity;

public class MainActivity extends AppCompatActivity {

    private TeaViewModel mViewModel;
    private ImageView mTeaCardImage;
    private TextView mTeaName;
    private TextView mTeaDescription;
    private TextView mTeaType;
    private ImageView mFavorite;
    private Button mBtnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TeaViewModelFactory factory = TeaViewModelFactory.createFactory(this);
        mViewModel = new ViewModelProvider(this, factory).get(TeaViewModel.class);

        mTeaCardImage = findViewById(R.id.tea_card_image);
        mTeaName = findViewById(R.id.tea_name);
        mTeaDescription = findViewById(R.id.description);
        mTeaType = findViewById(R.id.tea_type);
        mFavorite = findViewById(R.id.favorite);
        mBtnMoreInfo = findViewById(R.id.btn_more_info);

        mViewModel.getTea().observe(this, this::displayCard);

    }

    private void displayCard(Tea tea) {
        if (tea == null) {
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_add:
                intent = new Intent(this, AddTeaActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_timer:
                intent = new Intent(this, TimerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_list:
                intent = new Intent(this, TeaListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
