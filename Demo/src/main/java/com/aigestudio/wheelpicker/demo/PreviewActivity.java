package com.aigestudio.wheelpicker.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AigeStudio 2015-12-06
 * @author AigeStudio 2016-07-08
 */
public class PreviewActivity extends Activity implements WheelPicker.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_preview);

        WheelPicker wheelLeft = (WheelPicker) findViewById(R.id.main_wheel_left);
        wheelLeft.setOnItemSelectedListener(this);

        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.main_wheel_center);
        List<Integer> data = new ArrayList<>();
        for (int i = 1000; i < 3000; i++)
            data.add(i);
        wheelPicker.setData(data);

        WheelPicker wheelRight = (WheelPicker) findViewById(R.id.main_wheel_right);
        wheelRight.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_left:
                text = "Left:";
                break;
            case R.id.main_wheel_center:
                text = "Center:";
                break;
            case R.id.main_wheel_right:
                text = "Right:";
                break;
        }
        Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }
}