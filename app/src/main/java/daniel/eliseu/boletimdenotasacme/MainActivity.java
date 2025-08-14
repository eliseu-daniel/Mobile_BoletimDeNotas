package daniel.eliseu.boletimdenotasacme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtDisciplina, edtNota1, edtNota2, edtMedia, edtFalta, edtStatus;
    Button btnCalcular, btnNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtDisciplina = (EditText) findViewById(R.id.edtDisciplina);
        edtNota1 = (EditText) findViewById(R.id.edtNota1);
        edtNota2 = (EditText) findViewById(R.id.edtNota2);
        edtMedia = (EditText) findViewById(R.id.edtMedia);
        edtFalta = (EditText) findViewById(R.id.edtFalta);
        edtStatus = (EditText) findViewById(R.id.edtStatus);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnNovo = (Button) findViewById(R.id.btnNovo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float Media;
                Media = (Float.parseFloat(edtNota1.getText().toString()) + Float.parseFloat(edtNota2.getText().toString())) / 2;
                edtMedia.setText(String.valueOf(Media));

                int Falta = Integer.parseInt(edtFalta.getText().toString());
                if (Falta > 20) {
                    edtStatus.setText(String.valueOf("Reprovado por falta."));
                } else {
                    if (Media >= 6) {
                        edtStatus.setText(String.valueOf("Aprovado."));
                    }
                    else {
                        if (Media >= 3) {
                            edtStatus.setText(String.valueOf("Exame."));
                        } else {
                            edtStatus.setText(String.valueOf("Reprovado por nota."));
                        }
                    }
                }
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNome.setText("");
                edtDisciplina.setText("");
                edtNota1.setText("");
                edtNota2.setText("");
                edtMedia.setText("");
                edtStatus.setText("");
                edtFalta.setText("");
                edtNome.requestFocus();
            }
        });
    }
}