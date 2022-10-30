package com.margay.dolaremreal;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.common.base.Strings;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText textCotacao;
    private EditText textQuantidade;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCotacao = findViewById(R.id.textCotacao);
        textQuantidade = findViewById(R.id.textQuantidade);
        textResultado = findViewById(R.id.textResultado);
    }


    public void converter(View view) {

        String parseCotacao = String.valueOf(textCotacao.getText());
        String parseQtd = String.valueOf(textQuantidade.getText());

        if (Strings.isNullOrEmpty(parseCotacao) || Strings.isNullOrEmpty(parseQtd)) {
            throw new IllegalArgumentException("Valor inválido");
        }

        double result = Double.parseDouble(parseCotacao) * Double.parseDouble(parseQtd);
        String format = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR")).format(result);
        textResultado.setText(format);


    }
}