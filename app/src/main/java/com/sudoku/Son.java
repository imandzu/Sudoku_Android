package com.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.AccessControlContext;

/**
 * Created by ISMAIL on 29/12/2016.
 */
public class Son extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.son);



    }

    public void soundcontrole(View view)
    {
        String text_Button;
        text_Button = ((Button)view).getText().toString();
        if(text_Button.equals("Activer son"))
        {
            MenuPrincipale.SoundPlayer(this, R.raw.sonn);

        }

        else if (text_Button.equals("Disactiver son"))
        {
            MenuPrincipale.player.stop();
        }



    }
}
