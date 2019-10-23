package com.example.u3_b_a16alejandrobp;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class U3_B_A16AlejandroBP extends FragmentActivity {

    private DialogoFragmento dialogoFragmento = new DialogoFragmento();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onBotonClick(View view) {
        FragmentManager fm = getSupportFragmentManager();

        switch (view.getId()) {
            case R.id.btn_dialogo:
                dialogoFragmento.show(fm, "d");
                break;

                case R.id.btn_diag_tres_botons:
                dialogoFragmento.show(fm, "tb");
                break;

                case R.id.btn_diag_list_selecc:
                dialogoFragmento.show(fm, "l");
                    break;

                case R.id.btn_diag_radio_button:
                dialogoFragmento.show(fm, "rb");
                    break;

                case R.id.btn_diag_checkbox:
                dialogoFragmento.show(fm, "cb");
                    break;

                case R.id.btn_diag_entrada_texto:
                dialogoFragmento.show(fm, "et");
                    break;

                default:
                    break;

        }
    }
}