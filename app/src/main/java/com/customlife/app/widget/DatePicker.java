package com.customlife.app.widget;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.customlife.app.R;

import java.util.Calendar;

/**
 * @author LOVE
 *         <p/>
 *         负责人
 */
public class DatePicker extends LinearLayout {

    private Context context;

    private TextView dateText;

    private int year;
    private int month;
    private int day;

    public DatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.datepicker, this, true);
        init();
    }

    public DatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.datepicker, this, true);
        init();
    }

    /**
     * 构造方法
     */
    public DatePicker(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.datepicker, this, true);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (dateText == null) {
            init();
        }
    }

    private void init() {
        dateText = (TextView) findViewById(R.id.tv_date);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        dateText.setText(getThisTime());

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(
                                    android.widget.DatePicker view, int year,
                                    int monthOfYear, int dayOfMonth) {
                                DatePicker.this.year = year;
                                month = monthOfYear;
                                day = dayOfMonth;
                                dateText.setText(year + "-" + (monthOfYear + 1)
                                        + "-" + dayOfMonth);
                            }

                        }, year, month, day).show();
            }

        });

    }

    private String getThisTime() {
        return year + "-" + (month + 1) + "-" + day;
    }

    /**
     * 设置日期
     *
     * @return
     */
    public void setText(String dataString) {
        dateText.setText(dataString);
    }

    /**
     * 得到日期
     *
     * @return
     */
    public String getText() {
        return dateText.getText().toString();
    }

    public void setEnabled(boolean enabled) {
        dateText.setEnabled(enabled);
    }

}
