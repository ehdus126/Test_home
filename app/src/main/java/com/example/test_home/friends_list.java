package com.example.test_home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class friends_list extends AppCompatActivity {
    private TextView tv_id,tv_pass;
//    private ArrayList<HashMap<String,String>>Date=new ArrayList<HashMap<String, String>>();
//    private HashMap<String,String>InputData1=new HashMap<>();
//    private HashMap<String,String>InputData2=new HashMap<>();
    private ArrayList<Data> arrayList;
    private Adapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

//    private ListView listview;
//    private DatabaseReference mDatabase;
//    String[] list_friends={"friends1","friends2","friends3","friends4","friends5","friends6","friends7","friends8","friends9","friends10"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList=new ArrayList<>();

        mainAdapter=new Adapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        Button btn_add=(Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Data mainData=new Data(R.drawable.ic_perm_identity_black_24dp,"임도연");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged(); //액션 이루어지면 항상 새로고침 해짐
            }
        });

//        //listview=(ListView)findViewById(R.id.ListView1);
//
//        List<String>data=new ArrayList<>();
//
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//        //ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_list_view,list_friends);
//        listview.setAdapter(adapter); //리스트와 어댑터 연결
//
//        data.add("친구 1");
//        data.add("친구 2");
//        data.add("친구 3");
//        adapter.notifyDataSetChanged(); //데이터 저장

        //SimpleAdapter simpleAdapter=new SimpleAdapter(this,Data,android.R.layout.)
        //adapter 생성 후 listView에 지정
//        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.activity_friends_list,list_friends);
//        ListView listView=(ListView)findViewById(R.id.ListView1);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String steText=(String)adapterView.getItemAtPosition(i);
//            }
//        });

        TabHost tabHost1 = (TabHost)findViewById(R.id.tabHost1);
        tabHost1.setup();

        //첫번째 탭
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("",getResources().getDrawable(R.drawable.ic_person_black_24dp));
        //ts1.setIndicator("친구");
        tabHost1.addTab(ts1);

        //두번째 탭
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("",getResources().getDrawable(R.drawable.ic_comment_black_24dp));
        //ts2.setIndicator("채팅");
        tabHost1.addTab(ts2);

        //세번째 탭
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("",getResources().getDrawable(R.drawable.ic_reorder_black_24dp));
        //ts3.setIndicator("설정");
        tabHost1.addTab(ts3);

    }

    private class DatabaseReference {
    }
}

