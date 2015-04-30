package cn.edu.zafu.expand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mContext = null;
    private LayoutInflater mInflater = null;
    private List<GroupItem> mGroup = null;
    private List<List<ChildItem>> mChild = null;

    public MyBaseExpandableListAdapter(Context context, List<GroupItem> group, List<List<ChildItem>> child) {
        mContext = context;
        mGroup = group;
        mChild = child;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return mGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChild.get(groupPosition).size();
    }

    @Override
    public List<ChildItem> getGroup(int groupPosition) {
        return mChild.get(groupPosition);
    }

    @Override
    public ChildItem getChild(int groupPosition, int childPosition) {
        return mChild.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = null;
        GroupViewHolder viewHolder = null;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.group_item_layout, null);
            viewHolder = new GroupViewHolder();
            viewHolder.mGroupName = (TextView) view.findViewById(R.id.group_name);
            viewHolder.mGroupCount = (TextView) view.findViewById(R.id.group_count);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (GroupViewHolder) view.getTag();
        }
        viewHolder.mGroupName.setText(mGroup.get(groupPosition).getName());
        viewHolder.mGroupCount.setText("[" + mChild.get(groupPosition).size() + "]");
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = null;
        ChildViewHolder viewHolder = null;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.child_item_layout, null);
            viewHolder = new ChildViewHolder();
            viewHolder.mIcon = (ImageView) view.findViewById(R.id.img);
            viewHolder.mChildName = (TextView) view.findViewById(R.id.item_name);
            viewHolder.mDetail = (TextView) view.findViewById(R.id.item_detail);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ChildViewHolder) view.getTag();
        }
        viewHolder.mIcon.setBackgroundResource(getChild(groupPosition, childPosition).getResId());
        viewHolder.mChildName.setText(getChild(groupPosition, childPosition).getName());
        viewHolder.mDetail.setText(getChild(groupPosition, childPosition).getDetail());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    private class GroupViewHolder {
        TextView mGroupName;
        TextView mGroupCount;
    }

    private class ChildViewHolder {
        ImageView mIcon;
        TextView mChildName;
        TextView mDetail;
    }
}
