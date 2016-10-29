package cn.edu.gdmec.s07150750.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
        tv1 = (TextView) findViewById(R.id.textView1);
        Button button1 = (Button) this.findViewById(R.id.button1);
        Button button2 = (Button) this.findViewById(R.id.button2);
        Button button3 = (Button) this.findViewById(R.id.button3);
        Button button4 = (Button) this.findViewById(R.id.button4);
        Button button5 = (Button) this.findViewById(R.id.button5);
        Button button6 = (Button) this.findViewById(R.id.button6);
        Button button7 = (Button) this.findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }

            }

        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }

    public void dialog1() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确认退出吗？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    ad.dismiss();
                    MainActivity.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    ad.dismiss();
                }
            }

        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "退出", listenter);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL, "取消", listenter);
        ad.show();
    }

    public void dialog2() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你平时忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String str = "";

                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "杜甫很闲";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "杜甫无所谓在";
                        break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "很忙", listenter);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL, "很闲", listenter);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "一般", listenter);
        ad.show();
    }

    public void dialog3() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("请输入");
        ad.setMessage("请输入获奖感言");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        final EditText et1 = new EditText(this);
        ad.setView(et1);
        DialogInterface.OnClickListener lis3 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言：" + et1.getText().toString());
            }

        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "确定", lis3);
        ad.show();

    }

    public void dialog4() {

        final String item[] = new String[] { "北京", "上海", "广州" };
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4 = new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item, bSelect, lis4);
        ad = builder.create();
        ad.setTitle("多选框");
        DialogInterface.OnClickListener lis41 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                    String str = "你选了：";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "确定", lis41);
        ad.show();
    }

    public void dialog5() {
        final String item[] = new String[] { "北京", "上海", "广州" };
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which] = true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item, -1, lis5);
        ad = builder.create();
        ad.setTitle("单选");
        DialogInterface.OnClickListener lis51 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选了：";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "确定", lis51);
        ad.show();
    }

    public void dialog6() {
        final String item[] = new String[] { "北京", "上海", "广州" };
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：" + item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item, lis6);
        ad = builder.create();
        ad.setTitle("列表");
        DialogInterface.OnClickListener lis61 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", lis61);
        ad.show();
    }

    public void dialog7() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog, null);
        final EditText et1 = (EditText) layout.findViewById(R.id.editText1);
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener lis7 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是：" + et1.getText().toString());
            }

        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "确定", lis7);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", lis7);
        ad.show();
    }

}
