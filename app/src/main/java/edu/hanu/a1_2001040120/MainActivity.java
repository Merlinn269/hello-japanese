package edu.hanu.a1_2001040120;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_hiragana, btn_katakana;
    private TextView alphabet_title;
    private List<Alphabet> hiragana_image, katakana_image;
    private CustomAdapter hiraganaAdapter;
    private GridView gridView;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initHira();
        initKata();
        hiraganaAdapter = new CustomAdapter(MainActivity.this, hiragana_image);
        gridView.setAdapter(hiraganaAdapter);

        buttonClicked();
    }

    protected void buttonClicked() {
        btn_hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
                layout.startAnimation(animation);
                alphabet_title.setText(R.string.alphabet_hiragana);

                hiraganaAdapter = new CustomAdapter(MainActivity.this, hiragana_image);
                gridView.setAdapter(hiraganaAdapter);


            }
        });

        btn_katakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
                layout.startAnimation(animation);

                alphabet_title.setText(R.string.alphabet_katakana);

                hiraganaAdapter = new CustomAdapter(MainActivity.this, katakana_image);
                gridView.setAdapter(hiraganaAdapter);


            }
        });


    }

    protected void initView() {
        layout = findViewById(R.id.layout_top);
        btn_hiragana = findViewById(R.id.btn_hiragana);
        btn_katakana = findViewById(R.id.btn_katakana);
        alphabet_title = findViewById(R.id.text_view_selected_alphabet);
        gridView = findViewById(R.id.grid_view_alphabets);
    }

    protected void initHira() {
        hiragana_image = new ArrayList<>();
        hiragana_image.add(new Alphabet(R.drawable.a));
        hiragana_image.add(new Alphabet(R.drawable.i));
        hiragana_image.add(new Alphabet(R.drawable.u));
        hiragana_image.add(new Alphabet(R.drawable.e));
        hiragana_image.add(new Alphabet(R.drawable.o));

        hiragana_image.add(new Alphabet(R.drawable.ka));
        hiragana_image.add(new Alphabet(R.drawable.ki));
        hiragana_image.add(new Alphabet(R.drawable.ku));
        hiragana_image.add(new Alphabet(R.drawable.ke));
        hiragana_image.add(new Alphabet(R.drawable.ko));

        hiragana_image.add(new Alphabet(R.drawable.sa));
        hiragana_image.add(new Alphabet(R.drawable.shi));
        hiragana_image.add(new Alphabet(R.drawable.su));
        hiragana_image.add(new Alphabet(R.drawable.se));
        hiragana_image.add(new Alphabet(R.drawable.so));

        hiragana_image.add(new Alphabet(R.drawable.ta));
        hiragana_image.add(new Alphabet(R.drawable.chi));
        hiragana_image.add(new Alphabet(R.drawable.tsu));
        hiragana_image.add(new Alphabet(R.drawable.te));
        hiragana_image.add(new Alphabet(R.drawable.to));

        hiragana_image.add(new Alphabet(R.drawable.na));
        hiragana_image.add(new Alphabet(R.drawable.ni));
        hiragana_image.add(new Alphabet(R.drawable.nu));
        hiragana_image.add(new Alphabet(R.drawable.ne));
        hiragana_image.add(new Alphabet(R.drawable.no));

        hiragana_image.add(new Alphabet(R.drawable.ha));
        hiragana_image.add(new Alphabet(R.drawable.hi));
        hiragana_image.add(new Alphabet(R.drawable.fu));
        hiragana_image.add(new Alphabet(R.drawable.he));
        hiragana_image.add(new Alphabet(R.drawable.ho));

        hiragana_image.add(new Alphabet(R.drawable.ma));
        hiragana_image.add(new Alphabet(R.drawable.mi));
        hiragana_image.add(new Alphabet(R.drawable.mu));
        hiragana_image.add(new Alphabet(R.drawable.me));
        hiragana_image.add(new Alphabet(R.drawable.mo));

        hiragana_image.add(new Alphabet(R.drawable.ya));
        hiragana_image.add(new Alphabet(R.drawable.empty));
        hiragana_image.add(new Alphabet(R.drawable.yu));
        hiragana_image.add(new Alphabet(R.drawable.empty));
        hiragana_image.add(new Alphabet(R.drawable.yo));

        hiragana_image.add(new Alphabet(R.drawable.ra));
        hiragana_image.add(new Alphabet(R.drawable.ri));
        hiragana_image.add(new Alphabet(R.drawable.ru));
        hiragana_image.add(new Alphabet(R.drawable.re));
        hiragana_image.add(new Alphabet( R.drawable.ro));

        hiragana_image.add(new Alphabet( R.drawable.wa));
        hiragana_image.add(new Alphabet( R.drawable.empty));
        hiragana_image.add(new Alphabet( R.drawable.empty));
        hiragana_image.add(new Alphabet( R.drawable.empty));
        hiragana_image.add(new Alphabet( R.drawable.wo));

        hiragana_image.add(new Alphabet(R.drawable.n));
    }
    protected void initKata() {
        katakana_image = new ArrayList<>();
        katakana_image.add(new Alphabet(R.drawable.a1));
        katakana_image.add(new Alphabet(R.drawable.i1));
        katakana_image.add(new Alphabet(R.drawable.u1));
        katakana_image.add(new Alphabet(R.drawable.e1));
        katakana_image.add(new Alphabet(R.drawable.o1));

        katakana_image.add(new Alphabet(R.drawable.ka1));
        katakana_image.add(new Alphabet(R.drawable.ki1));
        katakana_image.add(new Alphabet(R.drawable.ku1));
        katakana_image.add(new Alphabet(R.drawable.ke1));
        katakana_image.add(new Alphabet(R.drawable.ko1));

        katakana_image.add(new Alphabet(R.drawable.sa1));
        katakana_image.add(new Alphabet(R.drawable.shi1));
        katakana_image.add(new Alphabet(R.drawable.su1));
        katakana_image.add(new Alphabet(R.drawable.se1));
        katakana_image.add(new Alphabet(R.drawable.so1));

        katakana_image.add(new Alphabet(R.drawable.ta1));
        katakana_image.add(new Alphabet(R.drawable.chi1));
        katakana_image.add(new Alphabet(R.drawable.tsu1));
        katakana_image.add(new Alphabet(R.drawable.te1));
        katakana_image.add(new Alphabet(R.drawable.to1));

        katakana_image.add(new Alphabet(R.drawable.na1));
        katakana_image.add(new Alphabet(R.drawable.ni1));
        katakana_image.add(new Alphabet(R.drawable.nu1));
        katakana_image.add(new Alphabet(R.drawable.ne1));
        katakana_image.add(new Alphabet(R.drawable.no1));

        katakana_image.add(new Alphabet(R.drawable.ha1));
        katakana_image.add(new Alphabet(R.drawable.hi1));
        katakana_image.add(new Alphabet(R.drawable.fu1));
        katakana_image.add(new Alphabet(R.drawable.he1));
        katakana_image.add(new Alphabet(R.drawable.ho1));

        katakana_image.add(new Alphabet(R.drawable.ma1));
        katakana_image.add(new Alphabet(R.drawable.mi1));
        katakana_image.add(new Alphabet(R.drawable.mu1));
        katakana_image.add(new Alphabet(R.drawable.me1));
        katakana_image.add(new Alphabet(R.drawable.mo1));

        katakana_image.add(new Alphabet(R.drawable.ya1));
        katakana_image.add(new Alphabet(R.drawable.empty));
        katakana_image.add(new Alphabet(R.drawable.yu1));
        katakana_image.add(new Alphabet(R.drawable.empty));
        katakana_image.add(new Alphabet(R.drawable.yo1));

        katakana_image.add(new Alphabet(R.drawable.ra1));
        katakana_image.add(new Alphabet(R.drawable.ri1));
        katakana_image.add(new Alphabet(R.drawable.ru1));
        katakana_image.add(new Alphabet(R.drawable.re1));
        katakana_image.add(new Alphabet(R.drawable.ro1));

        katakana_image.add(new Alphabet(R.drawable.wa1));
        katakana_image.add(new Alphabet(R.drawable.empty));
        katakana_image.add(new Alphabet(R.drawable.empty));
        katakana_image.add(new Alphabet(R.drawable.empty));
        katakana_image.add(new Alphabet(R.drawable.wo1));


        katakana_image.add(new Alphabet(R.drawable.n1));
    }



}


