package bigcode232_es.cofferun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CoffeeOptionsLoader extends BaseAdapter {
    Context context;
    Coffee[] coffeeList;
    LayoutInflater inflter;

    public CoffeeOptionsLoader(Context applicationContext, Coffee[] coffeeList) {
        this.context = context;
        this.coffeeList = coffeeList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return coffeeList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_coffee_item, null);
        TextView name = (TextView) view.findViewById(R.id.textView);
        final TextView price = (TextView) view.findViewById(R.id.coffeePrice);
        final EditText amountText = (EditText) view.findViewById(R.id.textAmount);
        final ImageView icon = (ImageView) view.findViewById(R.id.icon);

        final Coffee coffeeNode = coffeeList[i];
        price.setText((coffeeNode.getPrice()) + "$");
        name.setText(coffeeNode.getName());
        icon.setImageResource(coffeeNode.getIcon());
        Button addButton = (Button) view.findViewById(R.id.addButton);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(amountText.getText().toString());
                ProccessOrder.addCoffees(num, coffeeNode.getPrice());
            }
        });
        return view;
    }
}