package com.example.rravml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.CalendarView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{
     Button skip;
    private Button cland;
    CheckBox android, java, python, php, unity3D;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member member;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference=database.getInstance().getReference().child("Week");
        member=new Member();
          skip=findViewById(R.id.skip);
        // initiate views
        android = (CheckBox) findViewById(R.id.androidCheckBox);
       // android.setOnClickListener(this);
        java = (CheckBox) findViewById(R.id.javaCheckBox);
        //java.setOnClickListener(this);
        python = (CheckBox) findViewById(R.id.pythonCheckBox);
        //python.setOnClickListener(this);
        php = (CheckBox) findViewById(R.id.phpCheckBox);
        //php.setOnClickListener(this);
        unity3D = (CheckBox) findViewById(R.id.unityCheckBox);
       // unity3D.setOnClickListener(this);
        String a1="android";
        String a2="Java";
        String a3="python";
        String a4="php";
        String a5="Unity3D";
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                   i = (int)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.isChecked()){
                    member.setDay(a1);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else{
                    if(java.isChecked()){
                        member.setDay(a2);
                        reference.child(String.valueOf(i+1)).setValue(member);
                    }else{
                        if (python.isChecked()){
                            member.setDay(a3);
                            reference.child(String.valueOf(i+1)).setValue(member);
                        }else{
                            if (php.isChecked()){
                                member.setDay(a4);
                                reference.child(String.valueOf(i+1)).setValue(member);
                            }else{
                                if (unity3D.isChecked()){
                                    member.setDay(a5);
                                    reference.child(String.valueOf(i+1)).setValue(member);
                                }else {

                                }
                            }
                        }
                    }
                }
            }
        });




  //  @Override
  //  public void onClick(View v) {
      //  switch (v.getId()) {
           // case R.id.androidCheckBox:
             //   if (android.isChecked())
                   // Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_LONG).show();
           //     break;
          //  case R.id.javaCheckBox:
              //  if (java.isChecked())
             //       //Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_LONG).show();
           //     break;
          //  case R.id.phpCheckBox:
          //      if (php.isChecked())
                   // Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_LONG).show();
             //   break;
           // case R.id.pythonCheckBox:
                //if (python.isChecked())
                  //  Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_LONG).show();
             ///   break;
          //  case R.id.unityCheckBox:
              //  if (unity3D.isChecked())
               //   //  Toast.makeText(getApplicationContext(), "Unity 3D", Toast.LENGTH_LONG).show();
              //  break;




            }

         //   cland=(Button)findViewById(R.id.cland);
//cland.setOnClickListener(new View.OnClickListener() {
    //@Override
   // public void onClick(View v) {
      //  openClan();
 //   }
//});

       // }


public void openClan(){
        Intent intent=new Intent(this,Calander.class);
        startActivity(intent);
}

}