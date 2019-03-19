package com.example.qltc.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.qltc.R;
import com.example.qltc.model.MyTime;
import com.example.qltc.model.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThuTienFragment extends Fragment {
    private TextView textView;
    private ImageView anhMuc;
    private LinearLayout chonHangMucChi;
    private ImageView imgToLeft;

    private EditText editTien;
    private EditText editDienGiai;
    private TextView txtNgay;
    private TextView txtGio;
    private EditText editChuyenDi;
    private EditText editChiChoAi;
    private EditText editDiaDiem;

    public static String tienThu;
    public static String dienGiaiThu;
    public static String ngayThu;
    public static String gioThu;
    public static String chuyenDiThu;
    public static String chiChoAiThu;
    public static String diaDiemThu;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu_tien, container, false);
        anhMuc = view.findViewById(R.id.anhMuc);
        chonHangMucChi = view.findViewById(R.id.chonHangMucChi);
        textView = view.findViewById(R.id.chonmuc);
        imgToLeft = view.findViewById(R.id.toLeft);

        editTien =view.findViewById(R.id.tien);
        editDienGiai = view.findViewById(R.id.dienGiai);
        txtNgay = view.findViewById(R.id.ngay);
        txtGio = view.findViewById(R.id.gio);
        editChuyenDi = view.findViewById(R.id.chuyenDi);
        editChiChoAi = view.findViewById(R.id.thuTuAi);
        editDiaDiem = view.findViewById(R.id.diaDiemThu);

        //ngày giờ ban dầu
        String dateNow ;
        String timeNow;
        final MyTime myTime = new TimeUtils().getTime();
        dateNow = myTime.getMyTime();
        dateNow = "Hôm nay - "+dateNow;
        txtNgay.setText(dateNow);
        timeNow = myTime.getMyCurrentTime();
        txtGio.setText(timeNow);

        Bundle bundle = getArguments();
        if (bundle != null){
            String str = bundle.getString("key");
            textView.setText(str);
            int anh = bundle.getInt("anh");
            anhMuc.setImageResource(anh);

            editTien.setText(tienThu);
            editDienGiai.setText(dienGiaiThu);
            txtNgay.setText(ngayThu);
            txtGio.setText(gioThu);
            editChuyenDi.setText(chuyenDiThu);
            editChiChoAi.setText(chiChoAiThu);
            editDiaDiem.setText(diaDiemThu);
        }
        txtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),R.style.DatePickerDialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat MyTime = new SimpleDateFormat("dd/MM/yyyy");
                        mcurrentDate.set(year,month,dayOfMonth);
                        String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
                        String day = days[mcurrentDate.get(Calendar.DAY_OF_WEEK)-1];
                        txtNgay.setText(new TimeUtils().getDayName(day)+" - "+MyTime.format(mcurrentDate.getTime()));
                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });
        txtGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int gio= calendar.get(Calendar.HOUR_OF_DAY);
                int phut = calendar.get(Calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(getContext(),R.style.DatePickerDialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                        calendar.set(0,0,0,hourOfDay,minute);
                        txtGio.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },gio,phut,true);
                dialog.show();
            }
        });
        chonHangMucChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienThu = editTien.getText().toString();
                dienGiaiThu = editDienGiai.getText().toString();
                ngayThu = txtNgay.getText().toString();
                gioThu = txtGio.getText().toString();
                chuyenDiThu = editChuyenDi.getText().toString();
                chiChoAiThu = editChiChoAi.getText().toString();
                diaDiemThu = editDiaDiem.getText().toString();

                HangMucThuFragment hangMucThuFragment = new HangMucThuFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, hangMucThuFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        imgToLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ChiTienFragment chiTienFragment  = new ChiTienFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,chiTienFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
