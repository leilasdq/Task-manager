package com.example.homeworrrrrk9.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.homeworrrrrk9.Model.TaskManager;
import com.example.homeworrrrrk9.R;
import com.example.homeworrrrrk9.Repository.TasksRepository;
import com.example.homeworrrrrk9.TaskManagerFragmentPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.zip.Inflater;

public class ListsActivity extends AppCompatActivity {

    public static final String TAG_ADD_ITEM_FRAGMENTS = "Add item fragments";
    public static final String EXTRA_USER_NAME = "com.example.homeworrrrrk9.Controller.UserName";
    public static final String EXTRA_PASS_WORD = "com.example.homeworrrrrk9.Controller.PassWord";
    ViewPager mViewPager;
    TabLayout mTabLayout;
    private static String user;
    private static String pass;

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }


    public static Intent newIntent(Context context, String userName, String passWord){
        Intent intent = new Intent(context, ListsActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_PASS_WORD, passWord);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        initViews();
        user = getIntent().getStringExtra(EXTRA_USER_NAME);
        pass = getIntent().getStringExtra(EXTRA_PASS_WORD);

    }


    private void initViews(){
        mViewPager = findViewById(R.id.task_view_pager);
        //addBtn = findViewById(R.id.floatingActionButton);
        mTabLayout = findViewById(R.id.task_tab_layout);

        TaskManagerFragmentPagerAdapter adapter = new TaskManagerFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
