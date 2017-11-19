package com.qiyu.bottomdialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPopupWindow = (Button) findViewById(R.id.btn_popupwindow);
        btnPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhotoWindow();
            }
        });
    }


    private void showPhotoWindow() {
        View contentView = getLayoutInflater().inflate(R.layout.bottom_title_image, null);

//    若用此方法，Popup将覆盖底部导航栏  --->  pw = new PopupWindow(contentView, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());

        pw = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //设置动画
        pw.setAnimationStyle(R.style.popupwindow_anim_style);
        pw.setBackgroundDrawable(new ColorDrawable());
        pw.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        //初始化控件
        popupwindowselectphoto(contentView);
    }

    private void popupwindowselectphoto(View contentView) {
        TextView tv_select_pic = (TextView) contentView.findViewById(R.id.tv_photo);
        TextView tv_pai_pic = (TextView) contentView.findViewById(R.id.tv_photograph);
        TextView tv_cancl = (TextView) contentView.findViewById(R.id.tv_cancle);
        LinearLayout layout = (LinearLayout) contentView.findViewById(R.id.dialog_ll);
        tv_select_pic.setOnClickListener(popOnClick);
        tv_pai_pic.setOnClickListener(popOnClick);
        tv_cancl.setOnClickListener(popOnClick);
        layout.setOnClickListener(popOnClick);
    }

    private View.OnClickListener popOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_photo:
                    Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;
                case R.id.tv_photograph:
                    Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;
                case R.id.tv_cancle:
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;
                case R.id.dialog_ll:
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;
            }
        }
    };
}
