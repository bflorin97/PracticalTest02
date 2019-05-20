package ro.pub.cs.systems.eim.practicaltest02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest02MainActivity extends AppCompatActivity {

    EditText serverPort;
    EditText clientAddress;
    EditText clientPort;
    EditText prefix;

    Button serverConnect;
    Button clientConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);

        serverPort = findViewById(R.id.editText);
        clientAddress = findViewById(R.id.editText);
        clientPort = findViewById(R.id.editText);
        prefix = findViewById(R.id.editText);

        serverConnect = findViewById(R.id.button);
        clientConnect = findViewById(R.id.button2);
    }
}
