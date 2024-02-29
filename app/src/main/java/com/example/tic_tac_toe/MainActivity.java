package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean gameactive=true;

    // 0 -O
    // 1-X
    int activePlayer=0;
    int []gameState={2,2,2,2,2,2,2,2,2};
    // state
    // 0-x
   //  1-0
    // 2-empty
    int [][]winPositions={ {0,1,2}, {3,4,5} ,{6,7,8},
                           {0,3,6}, {1,4,7},  {2,5,8},
                            {0,4,8}  ,{ 2,4,6}};

    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        int cnt=0;
        if(!gameactive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2 && gameactive){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.two);
                activePlayer=1;
                TextView status=findViewById(R.id.textView4);
                status.setText("O's Turn -tap to play");

            }
            else {
                img.setImageResource(R.drawable.zero);
                activePlayer = 0;
                TextView status=findViewById(R.id.textView4);
                status.setText("X's Turn -tap to play");
            }
            cnt=cnt+1;
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int [] winPosition:winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!=2 ){
                //somebody has won
                //find out who
                gameactive=false;
                String winnerStr;
                if(gameState[winPosition[0]]==0){
                    winnerStr="X has won";
                }
                else{
                    winnerStr="O has won";
                }
                //update the status bar for winner announcement
                TextView status=findViewById(R.id.textView4);
                status.setText(winnerStr);
            }
        }
        if(cnt==8){
            TextView status=findViewById(R.id.textView4);
            status.setText("It is a draw ");
            gameactive=false;
        }

    }
    public void gameReset(View view){
        gameactive=true;
    activePlayer=0;
        Arrays.fill(gameState, 2);
   // gameState={2,2,2,2,2,2,2,2,2};
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}