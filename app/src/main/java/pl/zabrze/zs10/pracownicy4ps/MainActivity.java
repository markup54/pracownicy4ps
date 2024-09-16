package pl.zabrze.zs10.pracownicy4ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pracownik> pracownicy = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pracownicy.add(new Pracownik("Jaś","Tester",0));
        pracownicy.add(new Pracownik("Asia","Programista",2));
        pracownicy.add(new Pracownik("Isia","Informatyk",1));



    }
}