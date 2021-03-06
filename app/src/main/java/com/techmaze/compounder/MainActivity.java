package com.techmaze.compounder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> arraylist ;
    EditText et_StartinBalance, et_Annual , et_Periodic, et_Duration ;
    TextView tv_InvestmentValue, tv_profit, tv_Contributed ;
    TextView btn_yearly, btn_Quarterly, btn_Monthly, btn_Weekly ;
    double principal, rate ,time, CI , new_principal, periodic_addition , initial_principal;
    int investment_value ;
    int ci_int ;
    RecyclerView recyclerView_display;
    ArrayAdapter<Integer> arrayAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_center);

        setContentView(R.layout.activity_main);

        btn_yearly = (TextView) findViewById(R.id.btn_yearly);
        btn_Quarterly = (TextView) findViewById(R.id.btn_Quarterly);
        btn_Monthly = (TextView) findViewById(R.id.btn_Monthly);
        btn_Weekly = (TextView) findViewById(R.id.btn_Weekly);
        et_StartinBalance = (EditText) findViewById(R.id.et_StartinBalance);
        et_Annual = (EditText) findViewById(R.id.et_Annual);
        et_Periodic = (EditText) findViewById(R.id.et_Periodic);
        et_Duration = (EditText) findViewById(R.id.et_Duration);

        tv_InvestmentValue = (TextView) findViewById(R.id.tv_InvestmentValue);
        tv_profit = (TextView) findViewById(R.id.tv_profit);
        tv_Contributed = (TextView) findViewById(R.id.tv_Contributed);

        recyclerView_display = findViewById(R.id.recycler_ViewDisplay) ;
        recyclerView_display.setLayoutManager(new LinearLayoutManager(this));

        et_StartinBalance.setText("1000");
        et_Annual.setText("10");
        et_Periodic.setText("1000");
        et_Duration.setText("5");

        btn_yearly.setOnClickListener(new Click());
        btn_Quarterly.setOnClickListener(new Click());
        btn_Monthly.setOnClickListener(new Click());
        btn_Weekly.setOnClickListener(new Click());
        arraylist = new ArrayList<>() ;
        arraylist.add(1);
        arraylist.add(1);
        arraylist.add(1);arraylist.add(1);arraylist.add(1);arraylist.add(1);arraylist.add(1);arraylist.add(1);arraylist.add(1);


        arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, arraylist);
       // recyclerView_display.setAdapter(arrayAdapter);
    }

    public class Click implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_yearly:
                    arraylist = new ArrayList<>() ;
                    principal =Double.parseDouble(et_StartinBalance.getText().toString());
                    periodic_addition =Double.parseDouble(et_Periodic.getText().toString());
                    rate = Double.parseDouble(et_Annual.getText().toString());
                    time =Double.parseDouble(et_Duration.getText().toString());
                    initial_principal = principal ;
                    for (int i = 1 ; i<= time ; i++)
                    {
                        new_principal = (double)  principal * (1+ rate /100);
                        principal = new_principal + periodic_addition ;
                        arraylist.add((int) principal) ;
                    }
                    arrayAdapter.notifyDataSetChanged();
                    CI = principal - ( initial_principal + periodic_addition * time);
                    investment_value = (int) ( initial_principal + periodic_addition * time+CI);
                    ci_int  = (int) CI;
                    tv_InvestmentValue.setText("$ "+String.valueOf(investment_value));
                    tv_profit.setText("Profit $ "+String.valueOf(ci_int));
                    tv_Contributed.setText("Contributed $ "+String.valueOf(investment_value-ci_int));
                    break;
                case R.id.btn_Quarterly:
                    arraylist = new ArrayList<>() ;
                    principal =Double.parseDouble(et_StartinBalance.getText().toString());
                    periodic_addition =Double.parseDouble(et_Periodic.getText().toString());
                    rate = Double.parseDouble(et_Annual.getText().toString());
                    time =Double.parseDouble(et_Duration.getText().toString());
                    initial_principal = principal ;
                    for (int i = 1 ; i<= 4*time ; i++)
                    {
                        new_principal = (double)  principal * (1+ rate /400);
                        principal = new_principal + periodic_addition ;
                        arraylist.add((int) principal) ;
                    }
                    arrayAdapter.notifyDataSetChanged();
                    CI = principal - ( initial_principal + periodic_addition * 4*time);
                    investment_value = (int) ( initial_principal + periodic_addition * 4*time+CI);
                    ci_int  = (int) CI;
                    tv_InvestmentValue.setText("$ "+String.valueOf(investment_value));
                    tv_profit.setText("Profit $ "+String.valueOf(ci_int));
                    tv_Contributed.setText("Contributed $ "+String.valueOf(investment_value-ci_int));
                    break;
                case R.id.btn_Monthly:
                    arraylist = new ArrayList<>() ;
                    principal =Double.parseDouble(et_StartinBalance.getText().toString());
                    periodic_addition =Double.parseDouble(et_Periodic.getText().toString());
                    rate = Double.parseDouble(et_Annual.getText().toString());
                    time =Double.parseDouble(et_Duration.getText().toString());
                    initial_principal = principal ;
                    for (int i = 1 ; i<= 12*time ; i++)
                    {
                        new_principal = (double)  principal * (1+ rate /1200);

                        principal = new_principal + periodic_addition ;
                        arraylist.add((int) principal) ;
                    }
                    arrayAdapter.notifyDataSetChanged();
                    CI = principal - ( initial_principal + periodic_addition * 12*time);
                    investment_value = (int) ( initial_principal + periodic_addition * 12*time+CI);
                    ci_int  = (int) CI;
                    tv_InvestmentValue.setText("$ "+String.valueOf(investment_value));
                    tv_profit.setText("Profit $ "+String.valueOf(ci_int));
                    tv_Contributed.setText("Contributed $ "+String.valueOf(investment_value-ci_int));
                    break;

                case R.id.btn_Weekly:
                    arraylist = new ArrayList<>() ;
                    principal =Double.parseDouble(et_StartinBalance.getText().toString());
                    periodic_addition =Double.parseDouble(et_Periodic.getText().toString());
                    rate = Double.parseDouble(et_Annual.getText().toString());
                    time =Double.parseDouble(et_Duration.getText().toString());
                    initial_principal = principal ;
                    for (int i = 1 ; i<= 52*time ; i++)
                    {
                        new_principal = (double)  principal * (1+ rate /5200);
                        principal = new_principal + periodic_addition ;
                        arraylist.add((int) principal) ;
                    }
                    arrayAdapter.notifyDataSetChanged();
                    CI = principal - ( initial_principal + periodic_addition * 52*time);
                    investment_value = (int) ( initial_principal + periodic_addition * 52*time+CI);
                    ci_int  = (int) CI;
                    tv_InvestmentValue.setText("$ "+String.valueOf(investment_value));
                    tv_profit.setText("Profit $ "+String.valueOf(ci_int));
                    tv_Contributed.setText("Contributed $ "+String.valueOf(investment_value-ci_int));
                    Toast.makeText(MainActivity.this, String.valueOf(arraylist.size()), Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
    }
}