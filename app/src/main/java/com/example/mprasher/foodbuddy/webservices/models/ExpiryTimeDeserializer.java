package com.example.mprasher.foodbuddy.webservices.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExpiryTimeDeserializer implements JsonDeserializer<ExpiryTime>{
    @Override
    public ExpiryTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return formatExpiryTime(json.getAsString());
    }

    private ExpiryTime formatExpiryTime(String date) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
            String format = new SimpleDateFormat("dd MMM yyyy hh:mm a").format(parse);
            ExpiryTime orderCreatedAt = new ExpiryTime();
            orderCreatedAt.setExpiryTime(format);
            return orderCreatedAt;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
