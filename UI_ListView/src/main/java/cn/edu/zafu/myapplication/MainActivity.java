package cn.edu.zafu.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<Item> items=new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMenus();
        MyArrayAdapter adapter=new MyArrayAdapter(this,R.layout.item_layout,items);
        ListView listView= (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item=items.get(position);
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initMenus() {
        Item train=new Item(R.drawable.car,"ECMobile","蓝天神鹰","下午1:15");
        items.add(train);
        Item road=new Item(R.drawable.car,"YiiBook讨论群","UM5","下午2:23");
        items.add(road);
        Item history=new Item(R.drawable.car,"腾讯新闻","上海踩踏事件伤者惊魂","下午12:15");
        items.add(history);
    }
}
