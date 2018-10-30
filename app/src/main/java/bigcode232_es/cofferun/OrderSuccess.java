package bigcode232_es.cofferun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        String name = getIntent().getStringExtra("ORDER_NAME");
        int price = getIntent().getIntExtra("ORDER_AMOUNT", -1);
        String num = getIntent().getStringExtra("NUM_COFFEES");


        TextView orderName = (TextView) findViewById(R.id.orderName);
        TextView amount = (TextView) findViewById(R.id.totalPrice);

        orderName.setText("Order for " + name);
        amount.setText("Total Amount : " + price + "$");
    }
}
