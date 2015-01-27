package com.example.benet.calculadora2app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static float aux;
    private static char op=' ';
    private static char op2=' ';
    private static boolean inici=true;
    TextView label;
    public void calculadora(View view){
        switch(view.getId()){
            case R.id.btn0:
                if(op==' ') {
                    label.setText(label.getText().toString() + "0");
                }else{
                    label.setText("0");
                    op2=op;
                    op=' ';
                }
                break;
            case R.id.btn1:
                if(op==' ') {
                    label.setText(label.getText().toString() + "1");
                }else{
                    label.setText("1");
                    op2=op;
                    op=' ';
                }
                break;
            case R.id.btn2:
                if(op==' ') {
                    label.setText(label.getText().toString() + "2");
                }else{
                    label.setText("2");
                    op2=op;
                    op=' ';
                }
                break;
            case R.id.btn3:
                if(op==' ') {
                    label.setText(label.getText().toString() + "3");
                }else{
                    label.setText("3");
                    op2=op;
                    op=' ';
                }
                break;
            case R.id.btn4:
                label.setText(label.getText().toString()+"4");
                break;
            case R.id.btn5:
                label.setText(label.getText().toString()+"5");
                break;
            case R.id.btn6:
                label.setText(label.getText().toString()+"6");
                break;
            case R.id.btn7:
                label.setText(label.getText().toString()+"7");
                break;
            case R.id.btn8:
                label.setText(label.getText().toString()+"8");
                break;
            case R.id.btn9:
                label.setText(label.getText().toString()+"9");
                break;
            case R.id.btnpunt:
                label.setText(label.getText().toString()+".");
                break;
            case R.id.btnC:
                label.setText("");
                inici=true;
                op=' '; op2=' ';
                aux=0;
                break;
            case R.id.btnSum:
                op='+';
                calcular();
                break;
            case R.id.btnRes:
                op='-';
                calcular();
                break;
            case R.id.btnMulti:
                aux=Float.parseFloat(label.getText().toString());
                label.setText("");
                op='*';
                break;
            case R.id.btnDiv:
                aux=Float.parseFloat(label.getText().toString());
                label.setText("");
                op='/';
                break;
            case R.id.btnigual:
                calcular();
                break;
        }
    }

    public void calcular(){
        switch(op2){
            case '+':
                if(inici)inici=false;
                aux+=(Float.parseFloat(label.getText().toString()));
                label.setText(aux+"");
                break;
            case '-':
                if(!inici){
                    label.setText((aux)-(Float.parseFloat(label.getText().toString()))+"");
                }
                else{
                    aux=Float.parseFloat(label.getText().toString());
                    inici=false;
                }
                break;
            case '*':
                if(inici)inici=false;
                label.setText((aux)*(Float.parseFloat(label.getText().toString()))+"");
                aux=0;
                break;
            case '/':
                if(inici)inici=false;
                label.setText((aux)/(Float.parseFloat(label.getText().toString()))+"");
                aux=0;
                break;
            case '=':
                break;
            default:
                op2=op;
                calcular();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label=(TextView)findViewById(R.id.label);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
