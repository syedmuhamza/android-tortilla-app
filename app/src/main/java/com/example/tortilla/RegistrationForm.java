package com.example.tortilla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationForm extends AppCompatActivity {

    private Button signup;
    private EditText phone,name,password,passwordComparison;
    private TextView passwordMatchIndicator, numberCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_form);


//        getSupportActionBar().setTitle("Thank you for joining us");

        getSupportActionBar().hide();
        initializeComponents();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginSignUpProcess();
            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String toBeCounted=new String(phone.getText().toString());
                String empty=new String("");
                if(!toBeCounted.equals(empty)){
                    setTextOfCounter(toBeCounted);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String compareWith=new String(passwordComparison.getText().toString());
                String compareFrom=new String(password.getText().toString());
                comparison(compareFrom,compareWith);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordComparison.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String compareWith=new String(passwordComparison.getText().toString());
                String compareFrom=new String(password.getText().toString());
                comparison(compareFrom,compareWith);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void setTextOfCounter(String textOfCounter){
        int count=textOfCounter.length();
        int remaining=11-count;
        numberCounter.setText(String.valueOf(remaining)+" digits remaining");
        if(remaining==0){
            numberCounter.setText("Phone number complete");
            numberCounter.setTextColor(Color.GREEN);
        }
        else if(remaining<0){
            numberCounter.setText("Phone number must not exceed 11 digits");
            numberCounter.setTextColor(Color.RED);
        }
        else{
            numberCounter.setTextColor(Color.RED);
        }

    }

    private void comparison(String reference,String p){

        if(!reference.equals(p)){
            passwordMatchIndicator.setText("Passwords do not match");
            passwordMatchIndicator.setTextColor(Color.RED);
        }
        else{
            passwordMatchIndicator.setText("Passwords match");
            passwordMatchIndicator.setTextColor(Color.GREEN);
        }
    }

    private void beginSignUpProcess(){
        if(isCriteriaFulfilled()){

        }
    }

    private void initializeComponents() {
        signup=findViewById(R.id.reg_btn_signup);
        phone=findViewById(R.id.reg_txt_phone_number);
        password=findViewById(R.id.reg_txt_password);
        passwordComparison=findViewById(R.id.reg_txt_password_confirmation);
        passwordMatchIndicator=findViewById(R.id.reg_txt_password_status);
        passwordMatchIndicator.setText("");
        numberCounter=findViewById(R.id.reg_txt_number_counter);
        numberCounter.setText("11 digits remaining");
    }

    private boolean isCriteriaFulfilled(){
        if(isPasswordCriteriaFulfilled() && isPhoneNumberValid()){
            Toast.makeText(RegistrationForm.this,"Executing Registration",Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            Toast.makeText(RegistrationForm.this,"Error in process",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isPasswordCriteriaFulfilled(){
        String passwordFieldOne=new String(password.getText().toString());
        String passwordFieldTwo=new String(passwordComparison.getText().toString());
        if(passwordFieldOne.length()>=6 && passwordFieldOne.equals(passwordFieldTwo)){
            Toast.makeText(RegistrationForm.this,"Password OK",Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            Toast.makeText(RegistrationForm.this,"Password fault",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private boolean isPhoneNumberValid(){
        String phoneNumber=new String(phone.getText().toString());
        if(phoneNumber.length()==11){
//            Toast.makeText(RegistrationForm.this,"Phone Valid",Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            phone.setText("");
            phone.setHint("Required Field");
            phone.setHintTextColor(Color.RED);
            Toast.makeText(RegistrationForm.this,"Phone not Valid",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void passwordFieldColoringFunction(){
        if(true){
//            Drawable buttonDrawable = passwordComparison.getBackground();
//            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
//            DrawableCompat.setTint(buttonDrawable, Color.GREEN);
//            passwordComparison.setBackground(buttonDrawable);
//            passwordComparison.setTextColor(Color.RED);
//            passwordMatchIndicator.setText("Passwords do not match");
//            passwordMatchIndicator.setTextColor(Color.RED);
        }
        else{
//            Drawable buttonDrawable = passwordComparison.getBackground();
//            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
//            DrawableCompat.setTint(buttonDrawable, Color.RED);
//            passwordComparison.setBackground(buttonDrawable);
//            passwordComparison.setTextColor(Color.GREEN);
//            passwordMatchIndicator.setText("Passwords match");
//            passwordMatchIndicator.setTextColor(Color.GREEN);
        }
    }
}