package com.example.tortilla;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.GnssAntennaInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class OrderPage extends Fragment implements AdapterView.OnItemSelectedListener {


    static TextView greeting;
    String personName,personGivenName,personFamilyName,personEmail,personId;
    String[] itemList={"None","Roghni","Naan","Aloo","Qeema"};
    Spinner orderOne,orderTwo,orderThree;
    ImageView profileImage;
    ArrayAdapter arrayAdapter;
    Uri personPhoto;
    Button placeOrder;
    EditText txtQtyOne,txtQtyTwo,txtQtyThree;
    int selectionOne,selectionTwo,selectionThree,qtyOne=0,qtyTwo=0,qtyThree=0;

    public static final String TAG="MESSAGE";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.order_page, container, false);
        View parentView = inflater.inflate(R.layout.fragment_main_dashboard, container, false);



        initializeComponents(view);
        checkSignedInStatus();
        setUpUserProfile();



        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compileOrder();
                generateConfirmationDialogBox();
            }
        });
        return view;





    }

    private void compileOrder() {
        String empty=new String("");
        if(!txtQtyOne.getText().toString().equals(empty)){
            int compileOne=Integer.parseInt(String.valueOf(txtQtyOne.getText()));
            this.qtyOne=compileOne;
        }
        else{
            this.qtyOne=0;
        }
        if(!txtQtyTwo.getText().toString().equals(empty)){
            int compileTwo=Integer.parseInt(String.valueOf(txtQtyTwo.getText()));
            this.qtyTwo=compileTwo;
        }
        else{
            this.qtyTwo=0;
        }
        if(!txtQtyThree.getText().toString().equals(empty)){
            int compileThree=Integer.parseInt(String.valueOf(txtQtyThree.getText()));
            this.qtyThree=compileThree;
        }
        else{
            this.qtyThree=0;
        }

    }

    private void placeOrderInDatabase() {
        Toast.makeText(getActivity(),"1st Choice:"+itemName(selectionOne)+" 2nd Choice:"+itemName(selectionTwo)+" 3rd Choice:"+itemName(selectionThree),Toast.LENGTH_SHORT).show();
    }

    private void generateConfirmationDialogBox() {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getActivity());
        dlgAlert.setMessage(String.valueOf(qtyOne)+" "+itemName(selectionOne)+"\n"+String.valueOf(qtyTwo)+" "+itemName(selectionTwo)+"\n"+String.valueOf(qtyThree)+" "+itemName(selectionThree));
        dlgAlert.setTitle("Please Confirm Your Order");
        dlgAlert.setPositiveButton("Confirm", this::onClick);
        dlgAlert.setNegativeButton("No",this::onClick);
        dlgAlert.setCancelable(true);

        dlgAlert.create().show();
    }

    public void onClick(DialogInterface dialog,
                        int which){
        if(which==DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(),"CANCELLED",Toast.LENGTH_SHORT).show();
        }
        else{
            placeOrderInDatabase();
            Toast.makeText(getActivity(),"Order placed",Toast.LENGTH_SHORT).show();
        }
    }
    String itemName(int choice){
        switch (choice){
            case 0:
                return "None";
            case 1:
                return "Roghni";
            case 2:
                return "Naan";
            case 3:
                return "Aloo";
            case 4:
                return "Qeema";
            default:
                return "None";

        }
    }

    private void setUpUserProfile() {
//        dashboardText.setText("Welcome "+personName);
        greeting.setText("Welcome "+personName);
        orderOne.setOnItemSelectedListener(this);
        orderTwo.setOnItemSelectedListener(this);
        orderThree.setOnItemSelectedListener(this);
    }

    private void initializeComponents(View view) {
        arrayAdapter=new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,itemList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderOne=(Spinner)view.findViewById(R.id.menuSpinnerOne);
        orderTwo=(Spinner)view.findViewById(R.id.menuSpinnerTwo);
        orderThree=(Spinner)view.findViewById(R.id.menuSpinnerThree);
        orderOne.setAdapter(arrayAdapter);
        orderTwo.setAdapter(arrayAdapter);
        orderThree.setAdapter(arrayAdapter);
        profileImage=view.findViewById(R.id.profilePhoto);
        greeting=view.findViewById(R.id.welcomeMessage);
        placeOrder=view.findViewById(R.id.btn_place_order);
        txtQtyOne=view.findViewById(R.id.txt_qty_one);
        txtQtyTwo=view.findViewById(R.id.txt_qty_two);
        txtQtyThree=view.findViewById(R.id.txt_qty_three);
    }

    private void checkSignedInStatus() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            personName = new String(acct.getDisplayName().toString());
            personGivenName = new String(acct.getGivenName().toString());
            personFamilyName = new String(acct.getFamilyName().toString());
            personEmail = new String(acct.getEmail().toString());
            personId = new String(acct.getId().toString());
            personPhoto = acct.getPhotoUrl();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectionOne= (int) orderOne.getSelectedItemId();
        selectionTwo= (int) orderTwo.getSelectedItemId();
        selectionThree= (int) orderThree.getSelectedItemId();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

//android:theme="@style/Theme.Tortilla.AppBarOverlay"