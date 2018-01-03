package br.com.marcogorak.dialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnAlert;
    private AppCompatButton btnDialogItems;
    private AlertDialog alertDialog;
    private AlertDialog dialogItems;

    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = (AppCompatButton) findViewById(R.id.btn_alert);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog);
        builder.setMessage("Deseja excluir?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "SIM", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "NÃO", Toast.LENGTH_SHORT).show();
            }
        });



        AlertDialog.Builder builderDialogItens = new AlertDialog.Builder(this, R.style.AlertDialog);
        builderDialogItens.setTitle("Selecione a opção desejada: ");

        //builderDialogItens.setSingleChoiceItems(items, -1, null);

        builderDialogItens.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, items[i] + ":" + b, Toast.LENGTH_SHORT).show();
            }
        });

        builderDialogItens.setPositiveButton("OK", null);
        builderDialogItens.setNegativeButton("Cancelar", null);


        dialogItems = builderDialogItens.create();

        alertDialog = builder.create();



        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });


        btnDialogItems = (AppCompatButton) findViewById(R.id.btn_dialog_items);
        btnDialogItems.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogItems.show();
            }
        });
    }
}
