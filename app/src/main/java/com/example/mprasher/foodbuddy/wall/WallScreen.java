package com.example.mprasher.foodbuddy.wall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mprasher.foodbuddy.R;
import com.example.mprasher.foodbuddy.create_post.CreatePostScreen;
import com.example.mprasher.foodbuddy.regsteration.Registeration;
import com.example.mprasher.foodbuddy.utils.FoodBuddyPrefs;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.GetPostsSuccess;
import com.example.mprasher.foodbuddy.webservices.queries.GetWallPostsQuery;
import com.example.mprasher.foodbuddy.webservices.response.Hit;
import com.example.mprasher.foodbuddy.webservices.response.Source;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WallScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.wallList)RecyclerView wallListView;
    private FoodBuddyPrefs foodBuddyPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        foodBuddyPrefs = new FoodBuddyPrefs(this);

        GetWallPostsQuery getWallPostsQuery = new GetWallPostsQuery();
        getWallPostsQuery.getPosts();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButterKnife.bind(this);
        registerEventBus();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        wallListView.setLayoutManager(linearLayoutManager);

    }

    private ArrayList<WallRowModel> makeMockWallData() {
        ArrayList<WallRowModel> wallRowModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WallRowModel wallRowModel = new WallRowModel();
            wallRowModel.setDescription("We have left over from party like frozen chicken wings,tacos,vanilla etc.akjsdgkajsdgakjdsgakjdsgaksdaksdjgas");
            wallRowModel.setFoodTypes("Veggies, Frozen Food");
            wallRowModel.setPickUpLocation("133 Davidson Crescent, Regina");
            wallRowModel.setTimeString("2 hours from now");
            wallRowModel.setUserName("Khantil Patel");
            wallRowModel.setTitle("Have Some Frozen Food Left From Party");
            wallRowModels.add(wallRowModel);
        }
        return wallRowModels;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @OnClick(R.id.createPostButton)
    public void clickPost(){
        if(foodBuddyPrefs.isLoggedIn()){
            Intent intent = new Intent(this, CreatePostScreen.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Registeration.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStop() {
        unregister();
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetPostsSuccess success){
        ArrayList<Source> source = new ArrayList<>();
        List<Hit> hits = success.getHits();
        for (int i = 0; i < hits.size(); i++) {
            source.add(hits.get(i).getSource());
        }
        WallAdapter adapter = new WallAdapter(source);
        wallListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void registerEventBus(){
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    private void unregister(){
        EventBus.getDefault().unregister(this);
    }
}
