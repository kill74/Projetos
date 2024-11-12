package com.example.seekbarvolume;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VolumeActivity extends AppCompatActivity {


    //Criacao de variaveis
    SeekBar seekBar;
    TextView textView;
    ImageView imageView;
    Button button;
    boolean on = true; //PARA FAZER COMO O OUTRO RAPAZ FEZ >:)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volume);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }); // Fechei aqui pois estava a dar conflito com o codigo em baixo
            // mais especificamente com o "seekBar" e o "textView" (??)


            // isto ira buscar as variaveis que estao la em cima e os objetos que estam no activity
            seekBar = findViewById(R.id.seekBar);
            textView = findViewById(R.id.textView);
            imageView= findViewById(R.id.imageView2);
            button = findViewById(R.id.button);

            //Adicionei o que o professor disse no moodle
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    textView.setText(String.valueOf(progress));

                    /*if (progress == 0){
                        imageView.setImageResource(R.drawable.ic_volume_off); //nao sei porque isto nao funciona (18.10)
                    }*/
                    //isto serve para mudar a imagem consuante o volume
                    if (progress >= 0 && progress <= 30) {
                        imageView.setImageResource(R.drawable.ic_volume_low);
                    }
                    if (progress >= 31 && progress <= 70) {
                        imageView.setImageResource(R.drawable.ic_volume_medium);
                    }
                    if (progress >= 71 && progress <= 100) {
                        imageView.setImageResource(R.drawable.ic_volume_high);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
        });
    }

    // porque e que nao esta a dar ?? (por fazer!!!!!) (18.45)
    // que grande burro, porque e que guardei isto no onCreate ????????? (22.20)
    //ja esta a funcionar (22.20)
    public void disable(View v) {
        if(on) {
            imageView.setImageResource(R.drawable.ic_volume_off);
            on = false;
        } else {
            imageView.setImageResource(R.drawable.ic_volume_high);
            on = true;
        }
    }
}