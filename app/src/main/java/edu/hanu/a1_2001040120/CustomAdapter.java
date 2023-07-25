package edu.hanu.a1_2001040120;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private List<Alphabet> alphabets;
    private HashMap<Integer, Integer> soundMap = new HashMap<>();
    private MediaPlayer mediaPlayer;



    @SuppressLint("SuspiciousIndentation")
    public CustomAdapter(Activity activity, List<Alphabet> alphabets) {
        super();
        this.activity = activity;
        this.alphabets = alphabets;

            soundMap.put(0,R.raw.a);
            soundMap.put(1,R.raw.i);
            soundMap.put(2,R.raw.u);
            soundMap.put(3,R.raw.e);
            soundMap.put(4,R.raw.o);
            soundMap.put(5,R.raw.ka);
            soundMap.put(6,R.raw.ki);
            soundMap.put(7,R.raw.ku);
            soundMap.put(8,R.raw.ke);
            soundMap.put(9,R.raw.ko);
            soundMap.put(10,R.raw.sa);
            soundMap.put(11,R.raw.shi);
            soundMap.put(12,R.raw.su);
            soundMap.put(13,R.raw.se);
            soundMap.put(14,R.raw.so);
            soundMap.put(15,R.raw.ta);
            soundMap.put(16,R.raw.chi);
            soundMap.put(17,R.raw.tsu);
            soundMap.put(18,R.raw.te);
            soundMap.put(19,R.raw.to);
            soundMap.put(20,R.raw.na);
            soundMap.put(21,R.raw.ni);
            soundMap.put(22,R.raw.nu);
            soundMap.put(23,R.raw.ne);
            soundMap.put(24,R.raw.no);
            soundMap.put(25,R.raw.ha);
            soundMap.put(26,R.raw.hi);
            soundMap.put(27,R.raw.fu);
            soundMap.put(28,R.raw.he);
            soundMap.put(29,R.raw.ho);
            soundMap.put(30,R.raw.ma);
            soundMap.put(31,R.raw.mi);
            soundMap.put(32,R.raw.mu);
            soundMap.put(33,R.raw.me);
            soundMap.put(34,R.raw.mo);
            soundMap.put(35,R.raw.ya);
            soundMap.put(36,null);
            soundMap.put(37,R.raw.yu);
            soundMap.put(38,null);
            soundMap.put(39,R.raw.yo);
            soundMap.put(40,R.raw.ra);
            soundMap.put(41,R.raw.ri);
            soundMap.put(42,R.raw.ru);
            soundMap.put(43,R.raw.re);
            soundMap.put(44, R.raw.ro);
            soundMap.put(45, R.raw.wa);
            soundMap.put(46, null);
            soundMap.put(47, null);
            soundMap.put(48, null);
            soundMap.put(49, R.raw.wo);
            soundMap.put(50, R.raw.n);

    }

    @Override
    public int getCount() {
        return alphabets.size();
    }

    @Override
    public Object getItem(int i) {
        return alphabets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_gridview, null);

        ImageView img_alphabet = view.findViewById(R.id.alphabet);

        Alphabet alp = alphabets.get(position);
        img_alphabet.setImageResource(alp.getResId());

        img_alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(position);

                Animation animation = AnimationUtils.loadAnimation(img_alphabet.getContext(), R.anim.griditem_click);
                img_alphabet.startAnimation(animation);
            }
        });

        return view;
    }
    private void playSound(int position) {
        // Stop the previous sound if it's still playing
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        // Get the resource ID of the sound file for the selected image
        Integer soundResource = soundMap.get(position);
        if (soundResource == null) {
            return;
        }


        // Create a new MediaPlayer object and set the sound file as its data source
        mediaPlayer = MediaPlayer.create(activity, soundResource);

        // Start playing the sound
        mediaPlayer.start();

    }
}
