package com.example.drawer_expandablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
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
    public int getChildrenCount(int groupPosition) {
        if(listGroup != null && listItems != null) return listItems.get(listGroup.get(groupPosition)).size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItems.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return listGroup.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return listItems.get(listGroup.get(groupPosition)).get(childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false);
        }
        TextView tvGroup = convertView.findViewById(R.id.tv_group);
        GroupObject groupObject = listGroup.get(groupPosition);
        tvGroup.setText(groupObject.getName());

        ImageView imageView = convertView.findViewById(R.id.group_traillingIcon);
        if (listItems.get(listGroup.get(groupPosition)).size() > 0){
            if (isExpanded) {
                imageView.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
            } else {
                imageView.setImageResource(R.drawable.baseline_keyboard_arrow_right_24);
            }
        } else {
            imageView.setImageResource(0);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        }
        TextView tvGroup = convertView.findViewById(R.id.tv_item);
        ItemObject itemObject = listItems.get(listGroup.get(groupPosition)).get(childPosition);
        tvGroup.setText(itemObject.getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // sửa từ false
        return true;
    }
}
