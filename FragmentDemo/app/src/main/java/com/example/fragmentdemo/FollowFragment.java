package com.example.fragmentdemo;

import android.content.IntentFilter;
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

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;


public class FollowFragment extends Fragment {
    private TextView followTv;
    private int countNum;
    private CountHander countHander;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.follow_fragment, container, false);
        followTv = view.findViewById(R.id.follow_tv);
        countHander = new CountHander(followTv);
        followTv.setText("点击开始累加计数");
        followTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer1 = new Timer();
                timer2 = new Timer();
                timer3 = new Timer();
                timer1.schedule(new TimeAddThread(),0,1000);
                timer2.schedule(new TimeAddThread(),0,1000);
                timer3.schedule(new TimeAddThread(),0,1000);
//                for(int i =0 ;i<=3;i++){
//                    new AddThread().run();
//                }
            }
        });
        return view;


    }

    private static class CountHander extends Handler{
        private final WeakReference<TextView> followTv;

        CountHander(TextView followTvTmp){
            followTv=new WeakReference<>(followTvTmp);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView followSetTv = followTv.get();
            if(followSetTv!=null) {
                Log.d("count",msg.arg1+""+this.getClass().toString());
                followSetTv.setText(msg.arg1+"");
            }
        }
    }

    class TimeAddThread extends TimerTask {
        @Override
        synchronized public void run() {
            if(countNum<=30) {
                countNum = countNum + 1;
                Message message = new Message();
                message.arg1 = countNum;
                countHander.sendMessage(message);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer1!=null){
            timer1.cancel();
        }
        if(timer2!=null){
            timer2.cancel();
        }
        if(timer3!=null){
            timer3.cancel();
        }
    }
        class AddThread implements Runnable{
        @Override
        synchronized public void run() {
            while(countNum<=30) {
                countNum = countNum + 1;
                Message message = new Message();
                message.arg1 = countNum;
                countHander.sendMessage(message);
            }
        }
    }
}

