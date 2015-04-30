package cn.edu.zafu.expand;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ExpandableListView mExpandableListView = null;
    private MyBaseExpandableListAdapter mAdapter = null;
    private List<GroupItem> mGroup = new ArrayList<GroupItem>();
    private List<List<ChildItem>> mChild = new ArrayList<List<ChildItem>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();//初始化数据
        mExpandableListView = (ExpandableListView) findViewById(R.id.expand_listview);
        //mExpandableListView.setGroupIndicator(null);//前面的指示器设为无
        mAdapter = new MyBaseExpandableListAdapter(this, mGroup, mChild);//新建适配器
        mExpandableListView.setAdapter(mAdapter);//设置适配器
        mExpandableListView.setOnGroupClickListener(new MyOnGroupClickListener());//设置Group点击监听
        mExpandableListView.setOnChildClickListener(new MyOnChildClickListener());//设置Child点击监听
    }

    /*
    数据初始化
     */
    private void initData() {
        GroupItem groupItem = null;

        groupItem = new GroupItem("我的设备");
        mGroup.add(groupItem);
        groupItem = new GroupItem("我的好友");
        mGroup.add(groupItem);
        groupItem = new GroupItem("陌生人");
        mGroup.add(groupItem);

        List<ChildItem> child = null;
        ChildItem childItem = null;

        child = new ArrayList<ChildItem>();
        childItem = new ChildItem(R.drawable.expland_child_item, "我的电脑", "[在线]无需数据线，手机轻松传文件到电脑");
        child.add(childItem);
        childItem = new ChildItem(R.drawable.expland_child_item, "我的打印机", "将手机文件或照片发送到电脑连接的打印机");
        child.add(childItem);
        mChild.add(child);

        child = new ArrayList<ChildItem>();
        childItem = new ChildItem(R.drawable.expland_child_item, "羽人", "[在线]过去哪都不重要");
        child.add(childItem);
        childItem = new ChildItem(R.drawable.expland_child_item, "梦想逝去", "[在线]后来我眼瞎了");
        child.add(childItem);
        childItem = new ChildItem(R.drawable.expland_child_item, "啊飒飒", "[离线请留言]");
        child.add(childItem);
        mChild.add(child);

        child = new ArrayList<ChildItem>();
        childItem = new ChildItem(R.drawable.expland_child_item, "话说撒", "[在线]自行车自行车XC");
        child.add(childItem);
        childItem = new ChildItem(R.drawable.expland_child_item, "法规发生的变成", "[在线]啊实打实大学");
        child.add(childItem);
        childItem = new ChildItem(R.drawable.expland_child_item, "的感受到", "[离线请留言]");
        child.add(childItem);
        mChild.add(child);

    }

    /*
    一级事件监听
    */
    class MyOnGroupClickListener implements ExpandableListView.OnGroupClickListener {
        @Override
        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
            int count = mAdapter.getChildrenCount(groupPosition);
            Toast.makeText(getApplicationContext(), "拥有的子类个数:" + count, Toast.LENGTH_SHORT).show();
            return false;//返回false能继续处理展开动作，如果返回了true，则二级项不能展开
        }
    }

    /*
     二级事件监听
     */
    class MyOnChildClickListener implements ExpandableListView.OnChildClickListener {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            ChildItem item = mAdapter.getChild(groupPosition, childPosition);
            Toast.makeText(getApplicationContext(), "你点击了" + item.getName(), Toast.LENGTH_SHORT).show();
            return true;//事件被处理了返回true不能继续处理事件
        }
    }

}
