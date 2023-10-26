package com.example.expandablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListviewAdapter extends BaseExpandableListAdapter {

    private List<GroupObject> listGroup;
    private Map<GroupObject, List<ItemObject>> listItems;

    public ExpandableListviewAdapter(List<GroupObject> listGroup, Map<GroupObject, List<ItemObject>> listItems) {
        this.listGroup = listGroup;
        this.listItems = listItems;
    }

    @Override
    public int getGroupCount() {
        if(listGroup != null) return listGroup.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        if (listGroup != null && listItems != null) return listItems.get(listGroup.get(i)).size();
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return listGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listItems.get(listGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return listGroup.get(i).getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        return listItems.get(listGroup.get(i)).get(i1).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_group, viewGroup ,false);
        }
        TextView tvGroup = view.findViewById(R.id.tv_group);
        GroupObject groupObject = listGroup.get(i);
        tvGroup.setText(groupObject.getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
//            contex chứa thông tin trạng thái một view, có thể lấy nó từ getcontext của bất
//            cứ virew nào, ở đây lấy từ viewgroup, chủ yếu là để ké hàm chuyển layout thành
//            view: inflate()
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup ,false);
        }
        TextView tvGroup = view.findViewById(R.id.tv_item);
        ItemObject itemObject = listItems.get(listGroup.get(i)).get(i1);
        tvGroup.setText(itemObject.getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        // đã sửa từ false
        return true;
    }
}
