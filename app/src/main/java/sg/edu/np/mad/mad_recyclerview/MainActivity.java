package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText insertitem;
    Button addBtn;
    String userInput;
    ArrayList<String> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inserting task
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        insertitem = (EditText)findViewById(R.id.insertTask);
        addBtn = (Button) findViewById(R.id.AddBtn); //adding buttons
        taskList = new ArrayList<String>(); // adding the three main task into the list
        taskList.add("Buy Milk");
        taskList.add("Send Postage");
        taskList.add("Buy Android development Book");

        final RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(taskList,this);
        LinearLayoutManager mLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //add button listening for adding
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = insertitem.getText().toString();
                taskList.add(userInput);
                mAdapter.notifyDataSetChanged();

            }
        });

    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll down to the last recycler item
        rv.scrollToPosition(data.size() - 1);

        //automatically hide the keyboard after input
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
