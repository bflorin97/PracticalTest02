package ro.pub.cs.systems.eim.practicaltest02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Socket;

public class PracticalTest02MainActivity extends AppCompatActivity {

    EditText serverPort;
    EditText clientAddress;
    EditText clientPort;
    EditText prefix;

    TextView data;

    Button serverConnect;
    Button clientConnect;
    ServerThread serverThread;

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button: {
                    try {
                        Integer port = Integer.parseInt(serverPort.getText().toString());
                        serverThread = new ServerThread(port);
                        if (serverThread.getServerSocket() == null) {
                            throw new Exception();
                        }
                        serverThread.start();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case R.id.button2: {
                    try {
                        String prefixValue = prefix.getText().toString();
                        Integer port = Integer.parseInt(serverPort.getText().toString());
                        String address = clientAddress.getText().toString();
                        ClientThread clientThread = new ClientThread(address, port, prefixValue, data);
                        clientThread.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);

        serverPort = findViewById(R.id.editText);
        clientAddress = findViewById(R.id.editText4);
        clientPort = findViewById(R.id.editText3);
        prefix = findViewById(R.id.editText2);

        serverConnect = findViewById(R.id.button);
        clientConnect = findViewById(R.id.button2);

        data = findViewById(R.id.textView5);

        serverConnect.setOnClickListener(clickListener);
        clientConnect.setOnClickListener(clickListener);
    }
}
