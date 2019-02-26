package pl.lodz.uni.math.mjachowicz.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setListView(dataBase.getData().toString());
    }
    private DataBaseCalculator dataBase = new DataBaseCalculator(this);

    public void back(View view) {
        finish();
    }

    public void deleteHistory(View view) {
        dataBase.clearDatabase();
    }

    private void setListView(String data) {
        TextView listView = findViewById(R.id.historyView);
        listView.setText(data);
    }
}

