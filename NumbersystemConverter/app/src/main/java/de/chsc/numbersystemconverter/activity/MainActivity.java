package de.chsc.numbersystemconverter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import de.chsc.numbersystemconverter.R;
import de.chsc.numbersystemconverter.model.Number;
import de.chsc.numbersystemconverter.util.NumberSystemsConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFrom;
    private ArrayAdapter<CharSequence> arrayAdapter;
    private List<String> numberSystemsList;
    private List<String> numberSystemsTypeList;
    private List<TextView> textViewTypeList;
    private List<TextView> textViewResultList;
    private EditText etInputNumber;
    private TextView tvTypeFrom;
    private TextView tvTypeToOne;
    private TextView tvTypeToTwo;
    private TextView tvTypeToThree;
    private TextView tvResultOne;
    private TextView tvResultTwo;
    private TextView tvResultThree;
    private Button btnConvert;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initViews();
        this.initNumberSystemsList();
        this.initNumberSystemsTypeList();
        this.initTextViewResultList();
        this.initTextViewTypeList();
        this.initOnInputClickListener();
        this.initSpinner();
        this.setSpinnerToDefaultOptions();
        this.initSpinnerOnClickListener();
        this.initButtons();
        this.initButtonsOnClickListener();
    }

    private void initViews() {
        this.etInputNumber = findViewById(R.id.et_input_number);
        this.etInputNumber.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.tvTypeFrom = findViewById(R.id.tv_show_type_from);
        this.tvTypeToOne = findViewById(R.id.tv_show_type_to_one);
        this.tvTypeToTwo = findViewById(R.id.tv_show_type_to_two);
        this.tvTypeToThree = findViewById(R.id.tv_show_type_to_three);
        this.tvResultOne = findViewById(R.id.tv_result_one);
        this.tvResultTwo = findViewById(R.id.tv_result_two);
        this.tvResultThree = findViewById(R.id.tv_result_three);
    }

    private void initNumberSystemsList() {
        this.numberSystemsList = new ArrayList<>(
                Arrays.asList(getResources().getStringArray(R.array.number_systems_array)));
    }

    private void initNumberSystemsTypeList() {
        this.numberSystemsTypeList = new ArrayList<>(
                Arrays.asList(getResources().getStringArray(R.array.number_systems_type_array)));
    }

    private void initTextViewResultList() {
        this.textViewResultList = new ArrayList<>();
        this.textViewResultList.add(this.tvResultOne);
        this.textViewResultList.add(this.tvResultTwo);
        this.textViewResultList.add(this.tvResultThree);
    }

    private void initTextViewTypeList() {
        this.textViewTypeList = new ArrayList<>();
        this.textViewTypeList.add(this.tvTypeToOne);
        this.textViewTypeList.add(this.tvTypeToTwo);
        this.textViewTypeList.add(this.tvTypeToThree);
    }

    private void initOnInputClickListener() {
        this.etInputNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    convertButtonClicked();
                }
                return false;
            }
        });
    }

    private void initSpinner() {
        this.spinnerFrom = findViewById(R.id.spinner_from);

        this.arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.number_systems_array, android.R.layout.simple_spinner_item);
        this.arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerFrom.setAdapter(this.arrayAdapter);
    }

    private void setSpinnerToDefaultOptions() {
        String spinnerFromDefault = getResources().getString(R.string.number_system_from_default);
        this.spinnerFrom.setSelection(this.arrayAdapter.getPosition(spinnerFromDefault));
        this.setInputTypeNumber();
    }

    private void initSpinnerOnClickListener() {
        this.spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resetInput();
                resetResultViews();
                String selectedNumberSystem = parent.getItemAtPosition(position).toString();
                changeNumberSystems(selectedNumberSystem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void changeNumberSystems(String selectedNumberSystem) {
        int tvCounter = 0;
        int tvTypeCounter = 0;
        TextView temp;
        for (String ns : this.numberSystemsList) {
            if (!ns.equals(selectedNumberSystem)) {
                temp = this.textViewTypeList.get(tvCounter);
                temp.setText(this.numberSystemsTypeList.get(tvTypeCounter));
                tvCounter++;
            } else {
                this.tvTypeFrom.setText(this.numberSystemsTypeList.get(tvTypeCounter));
                this.checkInputType(selectedNumberSystem);
            }
            tvTypeCounter++;
        }
    }

    private void initButtons() {
        this.btnConvert = findViewById(R.id.button_convert);
        this.btnReset = findViewById(R.id.button_reset);
    }

    private void initButtonsOnClickListener() {
        this.btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertButtonClicked();
            }
        });

        this.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetResultViews();
                resetInput();
            }
        });
    }

    private void convertButtonClicked() {
        Number number = calculateNumbers();
        changeNumbers(number);
    }

    private Number calculateNumbers() {
        String nsType = tvTypeFrom.getText().toString();
        String value = etInputNumber.getText().toString();
        NumberSystemsConverter converter = new NumberSystemsConverter(nsType, value);
        Number number = converter.calculateNumber();
        return number;
    }

    private void changeNumbers(Number number) {
        if (this.tvTypeFrom.getText().equals("Dec")) {
            this.tvResultOne.setText(number.getBinNumber());
            this.tvResultTwo.setText(number.getOctNumber());
            this.tvResultThree.setText(number.getHexNumber());
        } else if (this.tvTypeFrom.getText().equals("Bin")) {
            this.tvResultOne.setText(number.getDecNumber());
            this.tvResultTwo.setText(number.getOctNumber());
            this.tvResultThree.setText(number.getHexNumber());
        } else if (this.tvTypeFrom.getText().equals("Oct")) {
            this.tvResultOne.setText(number.getDecNumber());
            this.tvResultTwo.setText(number.getBinNumber());
            this.tvResultThree.setText(number.getHexNumber());
        } else if (this.tvTypeFrom.getText().equals("Hex")) {
            this.tvResultOne.setText(number.getDecNumber());
            this.tvResultTwo.setText(number.getBinNumber());
            this.tvResultThree.setText(number.getOctNumber());
        }
    }

    private void resetInput() {
        this.etInputNumber.setText("");
    }

    private void resetResultViews() {
        this.tvResultOne.setText("");
        this.tvResultTwo.setText("");
        this.tvResultThree.setText("");
    }

    private void checkInputType(String selectedNumberSystem) {
        if (!selectedNumberSystem.equals("Hexadecimal")) {
            this.setInputTypeNumber();
        } else {
            this.setInputTypeText();
        }
    }

    private void setInputTypeNumber() {
        this.etInputNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void setInputTypeText() {
        this.etInputNumber.setInputType(InputType.TYPE_CLASS_TEXT);
    }
}