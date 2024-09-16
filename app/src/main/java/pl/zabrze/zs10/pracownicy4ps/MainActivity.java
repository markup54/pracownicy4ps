package pl.zabrze.zs10.pracownicy4ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pracownik> pracownicy = new ArrayList<>();
    TextView textViewImie;
    TextView textViewStanowisko;
    ImageView imageViewStaz;
    Button buttonDalej;
    Button buttonWstecz;
    int aktualnyNrPracownika = 0;
    Button buttonUsun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pracownicy.add(new Pracownik("Jaś","Tester",0));
        pracownicy.add(new Pracownik("Asia","Programista",2));
        pracownicy.add(new Pracownik("Isia","Informatyk",1));
        textViewImie = findViewById(R.id.textView);
        textViewStanowisko = findViewById(R.id.textView2);
        imageViewStaz = findViewById(R.id.imageView);

        wyswietlPracownika(aktualnyNrPracownika);
        buttonDalej = findViewById(R.id.button2);
        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnyNrPracownika++;
                        if(aktualnyNrPracownika == pracownicy.size()){
                            aktualnyNrPracownika = 0;
                        }
                        wyswietlPracownika(aktualnyNrPracownika);
                    }
                }
        );
        buttonWstecz = findViewById(R.id.button);
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnyNrPracownika --;
                        if(aktualnyNrPracownika<0) {
                            aktualnyNrPracownika = pracownicy.size() - 1;
                        }
                        wyswietlPracownika(aktualnyNrPracownika);
                    }
                }
        );
        buttonUsun = findViewById(R.id.button3);
        buttonUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pracownicy.size()>1) {
                            pracownicy.remove(aktualnyNrPracownika);
                            aktualnyNrPracownika = 0;
                            wyswietlPracownika(aktualnyNrPracownika);
                        }
                        else{

                            Toast.makeText(MainActivity.this,
                                    "To jest ostatni pracownik:)",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }


    private void wyswietlPracownika (int i){
        textViewImie.setText(pracownicy.get(i).getImie());
        textViewStanowisko.setText(pracownicy.get(i).getStanowisko());
        int[] idObrazkow = new int[]{R.drawable.junior, R.drawable.middle,R.drawable.senior};
        imageViewStaz.setImageResource(idObrazkow[pracownicy.get(i).getStaz()]);
    }
}