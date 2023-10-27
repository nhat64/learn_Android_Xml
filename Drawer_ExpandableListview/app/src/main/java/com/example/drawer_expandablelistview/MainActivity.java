package com.example.drawer_expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private List<GroupObject> listGroup;
    private Map<GroupObject, List<ItemObject>> listItems;
    private ExpandableListviewAdapter expandableListviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListview);

        listItems = getListItems();
        listGroup = new ArrayList<>(listItems.keySet());

        expandableListviewAdapter = new ExpandableListviewAdapter(listGroup, listItems);

        expandableListView.setAdapter(expandableListviewAdapter);

        expandableListView.setOnGroupExpandListener(groupPosition -> {
            Toast.makeText(MainActivity.this, listGroup.get(groupPosition).getName() + "expand", Toast.LENGTH_SHORT).show();
        });
        expandableListView.setOnGroupCollapseListener(groupPosition -> {
            Toast.makeText(MainActivity.this, listGroup.get(groupPosition).getName() + "collapse", Toast.LENGTH_SHORT).show();
        });
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
//            id là id của itemObject đã được cài đặt, còn groupPosition và childPosition là vị trí index
            Toast.makeText(MainActivity.this, groupPosition + " " + childPosition + " " + id, Toast.LENGTH_SHORT).show();
            return false;
        });
    }

    private Map<GroupObject, List<ItemObject>> getListItems () {
        Map<GroupObject, List<ItemObject>> listMap = new LinkedHashMap<>();

        GroupObject groupObject1 = new GroupObject(1, "Group 1");
        GroupObject groupObject2 = new GroupObject(2, "Group 2");
        GroupObject groupObject3 = new GroupObject(3, "Group 3");

        List<ItemObject> objectList1 = new ArrayList<>();
        objectList1.add(new ItemObject(1, "Item 1"));
        objectList1.add(new ItemObject(2, "Item 2"));
        objectList1.add(new ItemObject(3, "Item 3"));

        List<ItemObject> objectList2 = new ArrayList<>();
        objectList2.add(new ItemObject(4, "Item 4"));
        objectList2.add(new ItemObject(5, "Item 5"));
        objectList2.add(new ItemObject(6, "Item 6"));

        List<ItemObject> objectList3 = new ArrayList<>();
//        objectList3.add(new ItemObject(7, "Item 7"));
//        objectList3.add(new ItemObject(8, "Item 8"));
//        objectList3.add(new ItemObject(9, "Item 9"));

        listMap.put(groupObject1, objectList1);
        listMap.put(groupObject2, objectList2);
        listMap.put(groupObject3, objectList3);

        return listMap;
    }
}