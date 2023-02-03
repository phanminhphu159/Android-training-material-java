package com.example.java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;

/**
 * {@link #Activity} <- {@link #FragmentActivity} <- {@link #AppCompatActivity}
 * <p> FragmentActivity provides the ability to use Fragment.
 * <p>AppCompatActivity provides features to ActionBar
 * <p> the Android Documentation recommends using AppCompatActivity if you are using an App Bar
 */
public class MainActivity extends AppCompatActivity implements ISortSomeThing {
// class :
// - create objects .
// - represents the set of properties or methods that are common to all objects of one type.


    //Instantiate variable on global or class level
    private int age = 18;

    void setAge() {
        age = 2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // object
        MainActivity mainActivity = new MainActivity();



        Button btnHelloWorld = findViewById(R.id.btnHelloWorld);
        Intent intent = new Intent(this, SecondActivity.class);
        Product product = new Product("ID0001");
        intent.putExtra("parcelable",product);

        btnHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        // local variable :
        // - variable declared inside a method, constructors or a block.
        // - Only used inside the method or block that created it.
        // - Will be destroyed at the end of the method or block.
//        int age = 18;

        // final variable :
        // - can be explicitly initialized only once
        // - can never be reassigned to refer to a different object.
        // - the data within the object can be changed
        // - the final modifier often is used with static to make the constant a class variable.
        final ArrayList<Integer> arrayList = new ArrayList<Integer>(); // works fine
//        arrayList.add(0);
//        arrayList = new ArrayList<Integer>();


        Log.d("myArrayList ::: ", arrayList.toString());
        // DEBUG: Log.d
        // ERROR: Log.e
        // INFO: Log.i
        // VERBOSE: Log.v
        // WARN: Log.w


        // The static variable gets memory only once in class area at the time of class loading
        // public static final int BOXWIDTH = 6;


        // ---------------------------------------------------------------------------------------
        // Data Type
        // final ArrayList<Integer> arrayList = new ArrayList<Integer>(); // works fine
    }

    @Override
    public void sort() {
        quickSort();
    }

    // Access modifier
    protected void doSomeThing() {

    }

    private void quickSort(){

    }

    private void add(){
//        System.out.println(Adder.add(11,11));
//        System.out.println(Adder.add(12.3,12.6));
    }
}

class AccessModifier extends MainActivity implements ISortSomeThing {
    AccessModifier() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.doSomeThing();
        super.doSomeThing();
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    public void bubbleSort(){

    }
}

abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        initialize();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    protected abstract void initialize();

    void setFullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    void method(){

    }
}

interface ISortSomeThing {
    void sort();
}

class Adder{
    static int add(int a, int b){return a+b;}
    static double add(double a, double b){return a+b;}
}

class Product implements Parcelable{

    public String id;

    public Product(String id) {
        this.id = id;
    }

    protected Product(Parcel in) {
        id = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
    }
}