package moblie.tiy.androidappchat;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ListView list;
    EditText text;
    Button addButton;

    ArrayAdapter<String> items;
    ChatClient chatLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        chatLog = new ChatClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);

        addButton.setOnClickListener(this);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

       // items.add("Message 1");
       // items.add("Message 2");

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    @Override
    public void onClick (View v){
        String item = text.getText().toString();
      //  items.add(item);
        String returnedMessage = chatLog.sendMessage(item);
        text.setText("");
        items.add(returnedMessage);



    }

    @Override
    public boolean onItemLongClick (AdapterView < ? > parent, View view,int position, long id){
      //  String item = items.getItem(position);
      //  items.remove(item);
        return true;
    }
}
