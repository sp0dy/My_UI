package com.example.administrator.my_ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img;
    private ProgressBar progressBar;

    private static final int TIME = 3000;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_ui);
        EditText editText = (EditText) findViewById(R.id.et_ui);
        img = (ImageView) findViewById(R.id.img_ui);
        progressBar = (ProgressBar) findViewById(R.id.progress_ui);

        //TODO 监听方式二
        button.setOnClickListener(this);


        //TODO 监听方式一
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //更换图片
//                img.setImageResource(R.mipmap.e);


                //显示输入文字的吐司通知
//                String str = editText.getText().toString();
//                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    //TODO 监听方式二
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_ui:

                //TODO Dialog警示框
//                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("点击退出Acitivity");
//                dialog.setCancelable(true);
//                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "SB，是假的", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "这才是退出", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                });
//                dialog.show();

                //TODO ProgressDialog 加载警示框
                progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("我在飞奔");
                progressDialog.setMessage("努力的加载...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                handler.sendEmptyMessageDelayed(1,TIME);



                //TODO 点击一次加载一次进度
//                int progress = progressBar.getProgress();
//                progress = progress+10;
//                progressBar.setProgress(progress);

                //TODO 显示或者隐藏加载图标
//                if (progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }
                break;
        }
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
