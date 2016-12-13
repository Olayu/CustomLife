package com.customlife.app.fragment.one;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.customlife.app.R;
import com.customlife.app.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * 附近
 * <p>
 * Created by Zeng on 2016/11/26.
 */
@ContentView(R.layout.fragment_send)
public class SendFragment extends BaseFragment {
    @ViewInject(R.id.rb_send1)
    private RadioButton rb_send1;
    @ViewInject(R.id.rb_send2)
    private RadioButton rb_send2;
    @ViewInject(R.id.rb_send3)
    private RadioButton rb_send3;
    @ViewInject(R.id.rg_send)
    private RadioGroup rg_send;

//    private SendFragmentController controller;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        /*controller = SendFragmentController.getInstance(this, R.id.fl_content_send);
        controller.showFragment(0);*/
        rg_send.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_send1:
//                        controller.showFragment(0);
                        break;
                    case R.id.rb_send2:
//                        controller.showFragment(1);
                        break;
                    case R.id.rb_send3:
//                        controller.showFragment(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        controller.onDestroy();
    }
}
