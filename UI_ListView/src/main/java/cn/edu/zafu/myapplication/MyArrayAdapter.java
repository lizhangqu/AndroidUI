package cn.edu.zafu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyArrayAdapter extends ArrayAdapter<Item> {
    private int resourceId;
    public MyArrayAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder=new ViewHolder();
            viewHolder.icon= (ImageView) view.findViewById(R.id.item_icon);
            viewHolder.title= (TextView) view.findViewById(R.id.item_title);
            viewHolder.description= (TextView) view.findViewById(R.id.item_description);
            viewHolder.time= (TextView) view.findViewById(R.id.item_time);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.icon.setImageResource(item.getResId());
        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());
        viewHolder.time.setText(item.getTime());
        return view;
    }
    class ViewHolder{
        ImageView icon;
        TextView title;
        TextView description;
        TextView time;
    }
}
