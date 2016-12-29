package com.sudoku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



/**
 * Created by ISMAIL on 29/12/2016.
 */
public class MenuPrincipale extends Activity {

    public static MediaPlayer player;
    public static void SoundPlayer(Context ctx,int raw_id){
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(false); // Set looping
        player.setVolume(100, 100);

        //player.release();
        player.start();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        SoundPlayer(this, R.raw.sonn);


        setContentView(R.layout.menu_principale);

    }

    public void navigation(View view)
    {
        String text_Button;
        text_Button = ((Button)view).getText().toString();
        if(text_Button.equals("Jouer"))
        {
            Intent intent = new Intent(this, Sudoku.class);
            startActivity(intent);

        }

        else if (text_Button.equals("A propos"))
        {
            Intent intent = new Intent(this, Apropos.class);
            startActivity(intent);

        }
        else if (text_Button.equals("Meilleur score"))

        {
            Intent intent = new Intent(this, Score.class);
            startActivity(intent);

        }

        else if (text_Button.equals("Menu systeme"))
        {
            Intent intent = new Intent(this, Son.class);
            startActivity(intent);

        }


    }
}
