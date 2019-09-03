package com.example.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;


public class MineFragment extends Fragment {
    private TextView timeTv;
    private static final int START_TIME = 1;
    private static final int STOP_TIME = 0;
    private Timer timer;
    private CountHandler handler;
    private Context context;

    private Button UP;
    private Button DOWN;
    private MyFirstCombineView myFirstCombineView;


    private static class CountHandler extends Handler {
        private final WeakReference<TextView> target;
        private final WeakReference<Context> wContent;

        CountHandler(TextView timeTv, Context context) {
            target = new WeakReference<>(timeTv);
            wContent = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView handlerTv = target.get();
            Context context = wContent.get();
            if (handlerTv != null) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case START_TIME:
                        handlerTv.setText(context.getResources().getString(R.string.倒计时) + msg.arg1);
                        Log.d("time", "timechange" + msg.arg1);
                        break;
                    case STOP_TIME:
                        handlerTv.setText(context.getResources().getString(R.string.开始倒计时));
                        break;
                }
            } else {
                Log.d("time", "引用被回收");
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        timeTv = view.findViewById(R.id.time_tx);
        timeTv.setText(R.string.开始倒计时);
        context = this.getActivity();
        UP = view.findViewById(R.id.button_up);
        DOWN = view.findViewById(R.id.button_down);
        myFirstCombineView = view.findViewById(R.id.my_first_combine_view);
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        handler = new CountHandler(timeTv, context);
        super.onActivityCreated(savedInstanceState);
        timeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer == null) {
                    timer = new Timer();
                } else {
                    timer.cancel();
                    timer = new Timer();
                }
                timer.schedule(new TimerTask() {
                    int time = 30;

                    @Override
                    public void run() {
                        Message message = new Message();
                        if (handler != null) {
                            Log.d("time", handler.toString());
                        }
                        if (time >= 0) {
                            message.what = START_TIME;
                            message.arg1 = time;
                            if (handler != null) {
                                handler.sendMessage(message);
                            }
                            time--;
                        } else {
                            message.what = STOP_TIME;
                            if (handler != null) {
                                handler.sendMessage(message);
                            }
                            timer.cancel();
                        }
                    }
                }, 0, 1000);
            }
        });

        UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFirstCombineView.setUP();
            }
        });

        DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFirstCombineView.setDown();
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (timer != null) {
            timer.cancel();
        }
        handler.removeCallbacksAndMessages(null);
        Log.d("time", handler.toString() + "onDetach");
//            handler.removeCallbacksAndMessages(null);
    }
}
