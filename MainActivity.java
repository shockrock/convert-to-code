package code.convert.com.workshop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Fruit> fruits;
    ListView lvFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCLE", "onCreate");

        fruits = new ArrayList<Fruit>();
        fillArray();

        lvFruits = (ListView) findViewById(R.id.lvfruits);
        lvFruits.setAdapter(new FruitAdapter());

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE", "onRestart");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "onResume");
    }

    public void fillArray() {
        fruits.add( new Fruit("Apple", "granny smith, golden delicious", "https://en.wikipedia.org/wiki/Apple", R.drawable.apple) );
        fruits.add( new Fruit("Lemon", "meyer, libson", "https://en.wikipedia.org/wiki/Lemon", R.drawable.lemon) );
        fruits.add( new Fruit("Melon", "honeydew, canteloupe", "https://en.wikipedia.org/wiki/Melon", R.drawable.melon) );
        fruits.add( new Fruit("Peach", "clingstone, nectarine", "https://en.wikipedia.org/wiki/Peach", R.drawable.peach) );
        fruits.add( new Fruit("Pear", "anjou, bartlett", "https://en.wikipedia.org/wiki/Pear", R.drawable.pear) );
    }

    private class FruitAdapter extends BaseAdapter {

        public int getCount() {
            return fruits.size();
        }

        public Object getItem(int pos) {
            return fruits.get(pos);
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public View getView(int pos, View v, ViewGroup vg) {

            final Fruit fruit = fruits.get(pos);

            if (v == null) {
                v = LayoutInflater.from(getApplication()).inflate(R.layout.list_item, null);
                v.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            }

            v.findViewById(R.id.ivInfo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), DetailActivity.class);
                    intent.putExtra("wiki", fruit.wiki);

                    MainActivity.this.startActivity(intent);
                }
            });

            TextView tvAccount = (TextView) v.findViewById(R.id.tvName);
            TextView tvReader = (TextView) v.findViewById(R.id.tvVariety);

            tvAccount.setText(fruit.name);
            tvReader.setText(fruit.variety);

            ImageView ivFruit = (ImageView) v.findViewById(R.id.ivFruit);
            ivFruit.setImageDrawable(getDrawable(fruit.resource));

            return v;
        }
    }
}
