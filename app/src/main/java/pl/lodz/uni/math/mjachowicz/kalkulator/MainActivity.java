package pl.lodz.uni.math.mjachowicz.kalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private StringBuilder equation = new StringBuilder();
    private int lengthOfEquation = equation.length() - 1;
    private void addToDataBase(){dataBase.insertData(equation.toString() + " = " + result());
    }
    private DataBaseCalculator dataBase = new DataBaseCalculator(this);


    private double result() {
        Expression expression = new ExpressionBuilder(equation.toString()).build();
        return expression.evaluate();
    }

    private void showResult(){
        TextView textView = findViewById(R.id.showEquation);
        textView.setText(String.valueOf(result()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void refreshText() {

        TextView textView = findViewById(R.id.showEquation);
        textView.setText(equation.toString());

    }
    public void addToEquation(View view)
    {
     TextView button = (TextView) view;
     String character = button.getText().toString();
     if (lengthOfEquation > 13){
         return;
     }
     equation.append(character);
     refreshText();
    }

    public void calculateEquation(View view) {
        int lengthEquation = equation.length();
        if (lengthEquation < 1) {
            return;
        }
          showResult();
          addToDataBase();


       equation.delete(0, equation.length());


    }

    public void clearLast(View view)
    {
             if(equation.length()==0)
             {
                 return ;
             }
             else {
                 equation.delete(equation.length() - 1, equation.length());
                 refreshText();
             }

    }
    public void clearAll(View view)
    {
        equation.delete(0, equation.length());
        refreshText();
    }
    public void openHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

}

