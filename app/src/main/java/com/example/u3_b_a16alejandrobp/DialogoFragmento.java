package com.example.u3_b_a16alejandrobp;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoFragmento extends DialogFragment {
    int choice=0;
    int defChoice=0;
    boolean[] bCancel= new boolean[]{false,true,false,true,false,false,false};
    boolean[] bAccept= new boolean[]{false,true,false,true,false,false,false};
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch(getTag()) {
            case "d":
                builder.setTitle("Atención").setIcon(android.R.drawable.ic_dialog_email)
                        .setMessage("Nova amensaxe. Preme o botón 'Back' para volver á pantalla principal");
                break;
            case "tb":
                    builder.setTitle("Enquisa").setIcon(android.R.drawable.ic_dialog_info)
                    .setMessage("Compras sempre en grandes superficies?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Premeches 'Si'", Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Premeches 'Non'", Toast.LENGTH_LONG).show();
                        }
                    }).setNeutralButton("Ás veces", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Premeches 'Ás veces'", Toast.LENGTH_LONG).show();
                        }
                    });
                break;
            case "l":
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Escolle unha opción")
                .setItems(R.array.elementos_dialog_seleccion, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // O usuario selecciona unha das opcións do listado
                        String[] opcions = getResources().getStringArray(R.array.elementos_dialog_seleccion);
                        Toast.makeText(getActivity().getApplicationContext(), "Seleccionaches: '" + opcions[opcion] + "'", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case "rb":
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setTitle("Selecciona un smartpohone");
                // Non incluír mensaxe dentro de este tipo de diálogo!!!
                final CharSequence[] smartphones = { "iPhone", "Blackberry", "Android" };
                builder.setSingleChoiceItems(smartphones, defChoice, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // Evento que ocorre cando o usuario selecciona una opción
                        Toast.makeText(getActivity().getApplicationContext(), "Seleccionaches: " + smartphones[opcion], Toast.LENGTH_SHORT).show();
                        choice = opcion;
                    }
                });
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Premeches 'Aceptar'", Toast.LENGTH_SHORT).show();
                        defChoice = choice;
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                break;


            case "cb":
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setTitle("Selecciona modos de transporte");
                Resources res = getResources();
                final String[] matriz = res.getStringArray(R.array.elementos_dialog_seleccion2);
                final ArrayList<String> as = new ArrayList<String>();
                // Non incluír mensaxe dentro de este tipo de diálogo!!!
                builder.setMultiChoiceItems(matriz, bAccept, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                        // Evento que ocorre cando o usuario selecciona unha opción
                        if (isChecked){
                            Toast.makeText(getActivity().getApplicationContext(), "Seleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                            bCancel=bAccept;

                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "Deseleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                            bAccept=bCancel;
                        }
                    }
                });
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Premeches 'Aceptar'", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Premeches 'Cancelar'", Toast.LENGTH_LONG).show();
                    }
                });

                break;

            case "et":
                String infService = Context.LAYOUT_INFLATER_SERVICE;
                LayoutInflater li = (LayoutInflater) getActivity().getApplicationContext().getSystemService(infService);
                View inflador = li.inflate(R.layout.dialogo_entrada_texto, null);
                final TextView etNome = (TextView) inflador.findViewById(R.id.et_nome);
                final TextView etContrasinal = (TextView) inflador.findViewById(R.id.et_contrasinal);
                builder.setTitle("Indica usuario e contrasinal").setView(inflador);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Escribiches nome: '" + etNome.getText().toString() + "'. Contrasinal: '" + etContrasinal.getText().toString() + "' e premeches 'Aceptar'", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity().getApplicationContext(), "Premeches en 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                break;


            default:
                    break;
        }
        return builder.create();
    }
}