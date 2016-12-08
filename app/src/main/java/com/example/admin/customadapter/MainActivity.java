package com.example.admin.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    Button b;
    ListView lv;
    ArrayList<Employee> al;
    MyAdapter m;
    public class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return al.size();
        }


        @Override
        public Object getItem(int position) {
            return null;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View view,ViewGroup viewGroup) {
            Employee e=al.get(position);
            View v=getLayoutInflater().inflate(R.layout.row,null);
            TextView tv1= (TextView) v.findViewById(R.id.textview1);
            TextView tv2= (TextView) v.findViewById(R.id.textview2);
            TextView tv3= (TextView) v.findViewById(R.id.textview3);
            tv1.setText(e.getEno());
            tv2.setText(e.getEname());
            tv3.setText(e.getEsal());
            return v;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.edittext1);
        et2 = (EditText) findViewById(R.id.edittext2);
        et3 = (EditText) findViewById(R.id.edittext3);
        b = (Button) findViewById(R.id.button1);
        lv = (ListView) findViewById(R.id.listView);
        al = new ArrayList<Employee>();
        m = new MyAdapter();
        lv.setAdapter(m);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eno=et1.getText().toString();
                String ename=et2.getText().toString();
                String esal=et3.getText().toString();
                //to add arraylist after read eleements in button
                //create employee object
                Employee e=new Employee(eno,ename,esal);
                //FILL DATA INTO EMPLOYEE OBJECT
                e.setEno(eno);
                e.setEname(ename);
                e.setEsal(esal);
                al.add(e);
                //tell to adapter
                m.notifyDataSetChanged();
                //clean edit text values and request focous
                et1.requestFocus();


            }
        });

    }
}

        
