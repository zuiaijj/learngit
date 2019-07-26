package com.example.fragmentdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;


public class MineFragment extends Fragment {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {

            super.handleMessage(msg);
            switch (msg.what) {
                case START_TIME:
                    timeTv.setText(msg.arg1 + "");
                    Log.d("time", "timechange" + msg.arg1);
                    break;
                case STOP_TIME:
                    timeTv.setText("开始倒计时");
                    break;

            }
        }
    };
    private TextView timeTv;
    private static final int START_TIME = 1;
    private static final int STOP_TIME = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        timeTv = view.findViewById(R.id.time_tx);
        timeTv.setText("开始倒计时");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        timeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    int time = 30;

                    @Override
                    public void run() {
                        Message message = new Message();
                        if (time >= 0) {
                            message.what = START_TIME;
                            message.arg1 = time;
                            handler.sendMessage(message);
                            time--;
                        } else {
                            message.what = STOP_TIME;
                            handler.sendMessage(message);
                            timer.cancel();
                        }
                    }
                }, 0, 1000);
            }
        });

    }
}
