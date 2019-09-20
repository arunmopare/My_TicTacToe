package com.example.mytictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer=0;
    int[] myGameState = {2,2,2,2,2,2,2,2,2};
    //0 for cross and 1 for cross
    //my game state


    public void image_tapped(View view){
        ImageView myTapped=(ImageView)view;
       int tappedimageTag= Integer.parseInt(myTapped.getTag().toString());
        if (myGameState[tappedimageTag]==2){
            myGameState[tappedimageTag]=myActivePlayer;
            if (myActivePlayer==0){myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer=1;
            }
            else{
                myTapped.setImageResource(R.drawable.circle);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer=0;
            }
        }else{
            Log.d("msg","This place is Filled Already");
        }
    }
    public void playAgain(View view){
        //change game state back to two
        for(int i=0;i<myGameState.length;i++){
            myGameState[i]=2;
        }
        //make active player agin to 0
        int myActivePlayer=0;

        //reset images

        LinearLayout linearLayout1=(LinearLayout) findViewById(R.id.layout_one);
        for(int i=0; i<linearLayout1.getChildCount();i++){
            ((ImageView)linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2=(LinearLayout) findViewById(R.id.layout_two);
        for(int i=0; i<linearLayout2.getChildCount();i++){
            ((ImageView)linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout3=(LinearLayout) findViewById(R.id.layout_three);
        for(int i=0; i<linearLayout3.getChildCount();i++){
            ((ImageView)linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
