package cn.hnq.utsoft.retrofit_two.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import cn.hnq.utsoft.retrofit_two.Entity.DataEntity;
import cn.hnq.utsoft.retrofit_two.R;
import cn.hnq.utsoft.retrofit_two.utils.NetWork;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn_test);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                http();
            }
        });

    }

    //网络测试
    private void http() {
        Map<String,String> map=new HashMap<>();
        map.put("phone","13438284220");
        map.put("key","6fe9a2f9cc05e6941bcc45e30a32e51a");
        Disposable subscribe = NetWork.query(map, DataEntity.class).subscribe(new Consumer<DataEntity>() {
            @Override
            public void accept(DataEntity dataEntity) throws Exception {
               /* Toast.makeText(MainActivity.this, dataEntity.getResult().getCity(), Toast
                        .LENGTH_SHORT).show();*/
               Log.i("sss","成功");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("sss", throwable.toString());
                Toast.makeText(MainActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
        boolean disposed = subscribe.isDisposed();
        if (!disposed){
            subscribe.dispose();
        }
    }
}
