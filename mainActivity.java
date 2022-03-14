package com.example.calcjava;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.disp);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }
    private void upText(String StrToAdd){
        String OS=display.getText().toString();
        int CPOS= display.getSelectionStart();
        String LS=OS.substring(0,CPOS);
        String RS=OS.substring(CPOS);
        if(getString(R.id.disp).equals(display.getText().toString())){
            display.setText(StrToAdd);
            display.setSelection(CPOS+1);
        }
        else{
            display.setText(String.format("%s%s%s",LS,StrToAdd,RS));
            display.setSelection(CPOS+1);
        }
    }
    public void zeroBTN(View view)
    {
        upText("0");
    }
    public void brackBTN(View view){
        int CPOS= display.getSelectionStart();
        int openbrac=0;
        int closebrac=0;
        int textlength=display.getText().length();
        for(int i =0;i<CPOS;i++){
            if (display.getText().toString().substring(i,i+1).equals("(")){
                openbrac+=1;
            }
            if (display.getText().toString().substring(i,i+1).equals(")")){
                closebrac+=1;
            }
        }
        if(openbrac==closebrac|| display.getText().toString().substring(textlength-1,textlength).equals("(")){
            upText("(");
        }
        else if(closebrac<openbrac && !display.getText().toString().substring(textlength-1,textlength).equals("(")){
            upText(")");
        }
        display.setSelection(CPOS + 1);
    }
    public void pointBTN(View view){
        upText(".");
    }
    public void oneBTN(View view){
        upText("1");
    }
    public void twoBTN(View view){
        upText("2");
    }
    public void threeBTN(View view){
        upText("3");
    }
    public void fourBTN(View view){
        upText("4");
    }
    public void fiveBTN(View view){
        upText("5");
    }
    public void  sixBTN(View view){
        upText("6");
    }
    public void sevenBTN(View view){

        upText("7");
    }
    public void eightBTN(View view){

        upText("8");
    }
    public void nineBTN(View view){

        upText("9");
    }
    public void addBTN(View view){
        upText("+");
    }
    public void subBTN(View view){

        upText("-");
    }
    public void multiplyBTN(View view){
        upText("X");
    }
    public void divBTN(View view){
        upText("/");
    }
    public void powBTN(View view){

        upText("^");
    }
    public void clrBTN(View view){
        display.setText("");
    }
    public void equalBTN(View view){
        String uExp = display.getText().toString();
        uExp=uExp.replaceAll("X","*");
        uExp=uExp.replaceAll("/","/");

        Expression exp = new Expression(uExp);
        String Ans= String.valueOf(exp.calculate());
        display.setText(Ans);
        display.setSelection(Ans.length());
    }
    public void delBTN(View view){
        int CurPOS = display.getSelectionStart();
        int textlength = display.getText().length();
        if(CurPOS!=0 && textlength!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(CurPOS-1,CurPOS,"");
            display.setText(selection);
            display.setSelection(CurPOS-1);
        }
    }
}