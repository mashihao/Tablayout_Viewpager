package com.msh.tablayout_viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BaseOrderFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public BaseOrderFragment() {
        // Required empty public constructor
    }


    public static BaseOrderFragment newInstance(String param1) {
        BaseOrderFragment fragment = new BaseOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text = view.findViewById(R.id.text);
        text.setText(mParam1);
        doSomeWork();
    }

    //外面 点击或者滑动，刷新里面数据
    public void observerOutChangeRefresh() {
        Toast.makeText(getActivity(), "重新刷新-----" + mParam1, Toast.LENGTH_SHORT).show();
        doSomeWork();
    }

    public void doSomeWork() {

        //最你的网络请求

        switch (mParam1) {
            case "全部": {
            }
            break;
            case "待付款": {
            }
            break;
            case "待发货": {
            }
            break;
            case "已发货": {
            }
            break;
            case "已完成": {
            }
            break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}