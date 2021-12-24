package com.phuphuc.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    ImageButton ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int soDiem = 100;
    int diemCong = 10, diemTru = 5;
    String winMessage = "Bạn đoán chính xác!", lostMessage = "Bạn đoán sai rồi!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        txtDiem.setText(soDiem + "");
        CountDownTimer timer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);

                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ONE WIN!", Toast.LENGTH_SHORT).show();
                    if (cbOne.isChecked()) {
                        soDiem += diemCong;
                        Toast.makeText(MainActivity.this, winMessage, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        soDiem -= diemTru;
                        Toast.makeText(MainActivity.this, lostMessage, Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setEnable(true);
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN!", Toast.LENGTH_SHORT).show();
                    if (cbTwo.isChecked()) {
                        soDiem += diemCong;
                        Toast.makeText(MainActivity.this, winMessage, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        soDiem -= diemTru;
                        Toast.makeText(MainActivity.this, lostMessage, Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setEnable(true);
                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN!", Toast.LENGTH_SHORT).show();
                    if (cbThree.isChecked()) {
                        soDiem += diemCong;
                        Toast.makeText(MainActivity.this, winMessage, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        soDiem -= diemTru;
                        Toast.makeText(MainActivity.this, lostMessage, Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setEnable(true);
                }
            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    timer.start();
                    setEnable(false);
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

    private void setEnable(boolean b) {
        cbOne.setEnabled(b);
        cbTwo.setEnabled(b);
        cbThree.setEnabled(b);
    }

    private void AnhXa() {
        txtDiem = (TextView) findViewById(R.id.textviewDiemSo);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        skOne = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree = (SeekBar) findViewById(R.id.seekbarThree);
    }
}