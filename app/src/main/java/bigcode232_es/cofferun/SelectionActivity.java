package bigcode232_es.cofferun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SelectionActivity extends AppCompatActivity {

    ListView simpleList;
    Coffee[] coffeeList = {new Coffee(1, "Black", R.drawable.coffe1),
            new Coffee(2, "Mocha", R.drawable.coffee2),
            new Coffee(2, "Green Tea", R.drawable.coffee3),
            new Coffee(3, "Expresso", R.drawable.coffee4),
            new Coffee(4, "American Expresso", R.drawable.coffee5),
            new Coffee(2, "Latte", R.drawable.coffee6)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        CoffeeOptionsLoader customAdapter = new CoffeeOptionsLoader(getApplicationContext(), coffeeList);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        simpleList.setAdapter(customAdapter);

        final EditText orderName = (EditText) findViewById(R.id.orderName);
        final Button submitOrder = (Button) findViewById(R.id.submitOrder);

        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = orderName.getText().toString();
                ProccessOrder.submitOrder();
                //submit order
                //naviagate to confirmation page
                Intent intent = new Intent(getBaseContext(), OrderSuccess.class);
                intent.putExtra("ORDER_NAME", name);
                intent.putExtra("ORDER_AMOUNT", ProccessOrder.getPrice());
                intent.putExtra("NUM_COFFEES", ProccessOrder.getAmount());
                ProccessOrder.clearData();
                startActivity(intent);

            }
        });
    }
}
