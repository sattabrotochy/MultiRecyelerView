package com.example.multirecyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    private ParentAdapter parentAdapter;
    private List<ParentItem> parentItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        parentItemList = generateParentItems(); // Retrieve the parent item data (customize according to your needs)

        parentAdapter = new ParentAdapter(parentItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);



    }
    private List<ParentItem> generateParentItems() {
        List<ParentItem> parentItems = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            ParentItem parentItem = new ParentItem("Parent Item " + i);
            List<ChildItem> childItems = new ArrayList<>();

            for (int j = 1; j <= 5; j++) {
                ChildItem childItem = new ChildItem("Child Item " + j);
                childItems.add(childItem);
            }

            parentItem.setChildItemList(childItems);
            parentItems.add(parentItem);
        }

        return parentItems;
    }

    public class ParentItem {
        private String parentName;
        private List<ChildItem> childItemList;

        public ParentItem(String parentName) {
            this.parentName = parentName;
            this.childItemList = childItemList;
        }

        public String getParentName() {
            return parentName;
        }

        public List<ChildItem> getChildItemList() {
            return childItemList;
        }

        public void setChildItemList(List<ChildItem> childItemList) {
            this.childItemList = childItemList;
        }
    }

    public class ChildItem {
        private String childName;

        public ChildItem(String childName) {
            this.childName = childName;
        }

        public String getChildName() {
            return childName;
        }
    }

    //echo "# MultiRecyelerView" >> README.md
    //git init
    //git add README.md
    //git commit -m "first commit"
    //git branch -M master
    //git remote add origin https://github.com/sattabrotochy/MultiRecyelerView.git
    //git push -u origin master

}