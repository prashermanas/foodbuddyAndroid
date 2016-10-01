package com.example.mprasher.foodbuddy.create_post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mprasher.foodbuddy.R;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.PostFailed;
import com.example.mprasher.foodbuddy.webservices.events.create_post_events.PostSuccess;
import com.example.mprasher.foodbuddy.webservices.models.CreatePostRequest;
import com.example.mprasher.foodbuddy.webservices.queries.FoodPostCreateQuery;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CreatePostScreen extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    @BindView(R.id.titleText)TextView title;
    @BindView(R.id.veggies)AppCompatCheckBox veggies;
    @BindView(R.id.cookedFood)AppCompatCheckBox cookedFood;
    @BindView(R.id.packedFood)AppCompatCheckBox packedFood;
    @BindView(R.id.pickupLocation)EditText pickUpLocation;
    @BindView(R.id.dropOffSelected)AppCompatCheckBox dropOffSelected;
    @BindView(R.id.descriptionText)EditText description;
    @BindView(R.id.dateLabel)TextView dateLabel;
    @BindView(R.id.timeLabel)TextView timeLabel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);
        ButterKnife.bind(this);
        registerEventBus();
        setTodaysDateAndTime();

    }

    @Override
    protected void onStop() {
        unregisterEventBus();
        super.onStop();
    }

    private String getFoodTypes(){
        String veggiesString = veggies.isChecked() ? veggies.getText().toString() : "";
        String cookedFood = this.cookedFood.isChecked() ? this.cookedFood.getText().toString() : "";
        String packedFood = this.packedFood.isChecked() ? this.packedFood.getText().toString() : "";
        return veggiesString
                +","+
                cookedFood
                +","+
                packedFood;
    }

    private void setTodaysDateAndTime() {
        dateLabel.setText(getDateString());
        timeLabel.setText(getTimeString());
    }

    public static String getDateString() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static String getTimeString() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    private boolean isUiValid(){
        if(TextUtils.isEmpty(title.getText().toString())){
            title.setError("Please specify Title of post");
            return false;
        }
        if(!veggies.isChecked()
                ||
                !cookedFood.isChecked()
                ||
                !packedFood.isChecked()){
            Toast.makeText(this,"Please select type of Food Which you are Posting",Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(pickUpLocation.getText())){
           pickUpLocation.setError("Please specify pickup location");
            return false;
        }
        if(TextUtils.isEmpty(description.getText())){
            description.setError("Please provide description");
            return false;
        }
        return true;
    }

    @OnClick(R.id.date)
    public void onClickDate(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");

    }

    @OnClick(R.id.time)
    public void onClickTime(){
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        );
        tpd.show(getFragmentManager(),"TimepickerDialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = year+"-"+(++monthOfYear)+"-"+dayOfMonth;
        dateLabel.setText(date);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        String time = hourString+":"+minuteString+":"+secondString;
        timeLabel.setText(time);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPostCreated(PostSuccess postSuccess){
        showToastMessage("Posted Successfully");
        finish();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPostCreatedfailed(PostFailed postFailed){
        showToastMessage(postFailed.getErrorMessage());
    }

    private void showToastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void registerEventBus(){
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    private void unregisterEventBus(){
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.Submit)
    public void onPost(){
        if(isUiValid()){
            FoodPostCreateQuery foodPostCreateQuery = new FoodPostCreateQuery();
            CreatePostRequest createPostRequest = new CreatePostRequest();
            createPostRequest.setUserName(createPostRequest.getUserName());
            createPostRequest.setFoodTypes(getFoodTypes());
            createPostRequest.setDroppingOff(dropOffSelected.isChecked());
            createPostRequest.setPostPickupLocation(pickUpLocation.getText().toString());
            createPostRequest.setDescription(description.getText().toString());
            foodPostCreateQuery.createPost(createPostRequest);
        }
    }
}
