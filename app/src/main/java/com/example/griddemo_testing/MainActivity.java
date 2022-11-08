package com.example.griddemo_testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] fruitNames = {"Apple", "orange", "strawberry", "melon", "kiwi", "banana"};
    int[]  fruitsImages = {R.drawable.apple, R.drawable.orange, R.drawable.strawberry, R.drawable.watermelon, R.drawable.kiwi, R.drawable.banana};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

       CustomAdapter customAdapter = new CustomAdapter();

       gridView.setAdapter(customAdapter);

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
               intent.putExtra("name", fruitNames[i]);
               intent.putExtra("image", fruitsImages[i]);
               startActivity(intent);
           }
       });
    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return fruitsImages.length;
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

            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            image.setImageResource(fruitsImages[i]);
            return view1;
        }
    }
}