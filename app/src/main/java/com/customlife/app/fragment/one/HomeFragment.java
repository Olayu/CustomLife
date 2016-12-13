package com.customlife.app.fragment.one;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.activity.GoodsDetailsActivity;
import com.customlife.app.activity.one.DayCrazyActivity;
import com.customlife.app.activity.one.DayNewActivity;
import com.customlife.app.activity.one.HotBuyActivity;
import com.customlife.app.activity.one.RecommendActivity;
import com.customlife.app.adapter.AddressAdapter;
import com.customlife.app.adapter.DayCrazyAdapter;
import com.customlife.app.adapter.DayNewAdapter;
import com.customlife.app.adapter.HotBuyAdapter;
import com.customlife.app.adapter.MenuAdapter;
import com.customlife.app.adapter.RecommendAdapter;
import com.customlife.app.api.ApiHttpClient;
import com.customlife.app.api.remote.Api;
import com.customlife.app.base.BaseFragment;
import com.customlife.app.bean.Ad;
import com.customlife.app.bean.Banner;
import com.customlife.app.bean.Bean;
import com.customlife.app.bean.MenuBean;
import com.customlife.app.widget.JingDongHeaderLayout;
import com.customlife.app.widget.ViewNewsHeader;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * 便宜购-首页
 * <p>
 * Created by Zeng on 2016/11/26.
 */

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {
    private Context context;

    @ViewInject(R.id.rl_actionbar)
    private LinearLayout actionBar;
    @ViewInject(R.id.gridview)
    private GridView gridView;
    @ViewInject(R.id.news)
    private ViewNewsHeader header;
    @ViewInject(R.id.scrollview)
    private PullToRefreshScrollView scrollView;
    @ViewInject(R.id.layout_address)
    private LinearLayout addressLayout;
    @ViewInject(R.id.actionbar_tv_left)
    private TextView addressTv;
    @ViewInject(R.id.actionbar_img_left)
    private ImageView arrowDownImg;
    @ViewInject(R.id.actionbar_share)
    private ImageView shareImg;
    @ViewInject(R.id.actionbar_search)
    private EditText searchEdit;
    @ViewInject(R.id.layout_main)
    private LinearLayout mainLayout;
    private MenuAdapter menuAdapter;
    private AddressAdapter addressAdapter;
    private boolean isOpen;

    @ViewInject(R.id.day_crazy_listview)
    private ListView dayCrazyListView;
    @ViewInject(R.id.recommend_listview)
    private ListView recommendListView;
    @ViewInject(R.id.hot_buy_listview)
    private ListView hotBuyListView;
    private View dayCrazyHeader;
    private View recommendHeader;
    private View hotBuyHeader;
    private DayCrazyAdapter dayCrazyAdapter;
    private RecommendAdapter recommendAdapter;
    private HotBuyAdapter hotBuyAdapter;
    private ArrayList<Bean> dayCrazyList;

    @ViewInject(R.id.day_new_gridview)
    private GridView dayNewGridView;
    private DayNewAdapter dayNewAdapter;

//    private int bannerViewHeight; // 广告视图的高度
//    private int bannerViewTopMargin; // 广告视图距离顶部的距离
//    private int titleViewHeight; // 标题栏的高度

    private PopupWindow mPopupWindow;
    private GridView addressGridView;
    //    private RecyclerView addressRecyclerView;
    private List<Banner> list;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        context = getContext();
//        actionBar = new ActionbarBuilder(view).setTitleText("主页").getView();
//        bannerViewTopMargin = actionBar.getTop();
//        titleViewHeight = actionBar.getHeight();
//        bannerViewHeight = header.getHeight();
        scrollView.setHeaderLayout(new JingDongHeaderLayout(getActivity()));
        header.setRefreshLayout(scrollView);
        menuAdapter = new MenuAdapter(getActivity(), R.layout.item_home_menu);
        gridView.setAdapter(menuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent2Activity(DayCrazyActivity.class);
                        break;
                    case 1:
                        intent2Activity(DayNewActivity.class);
                        break;
                    case 2:
                        intent2Activity(RecommendActivity.class);
                        break;
                    case 3:
                        intent2Activity(HotBuyActivity.class);
                        break;
                }
            }
        });
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                getImageList();
            }
        });
        initMenu();
        addressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    isOpen = false;
                    arrowDownImg.animate().setDuration(300).rotation(0).start();
                    mPopupWindow.dismiss();
                } else {
                    arrowDownImg.animate().setDuration(300).rotation(-180).start();
                    initPoppupWindow();
                }
            }
        });
        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpen = false;
                arrowDownImg.animate().setDuration(300).rotation(0).start();
                mPopupWindow.dismiss();
            }
        });

        dayCrazyList = new ArrayList<>();
        dayCrazyList.add(new Bean());
        dayCrazyList.add(new Bean());

        initDayCrazy();
        initDayNew();
        initRecommend();
        initHotBuy();

    }

    /**
     * 今日新品
     */
    public void initDayNew() {
        dayNewAdapter = new DayNewAdapter(context, R.layout.item_day_new);
        dayNewGridView.setAdapter(dayNewAdapter);
        dayNewGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        dayNewAdapter.setData(dayCrazyList);
        dayNewAdapter.notifyDataSetChanged();
        setGridViewHeightBasedOnChildren(dayNewGridView);
    }

    /**
     * 超值热购
     */
    public void initHotBuy() {
        hotBuyHeader = LayoutInflater.from(context).inflate(R.layout.header_home_base, null);
        TextView title = (TextView) hotBuyHeader.findViewById(R.id.tv_title);
        title.setText("超值热购");
        hotBuyHeader.measure(0, 0);
        hotBuyListView.addHeaderView(hotBuyHeader,null,false);
        hotBuyAdapter = new HotBuyAdapter(context, R.layout.item_hot_buy);
        hotBuyListView.setAdapter(hotBuyAdapter);
        hotBuyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
                intent2Activity(GoodsDetailsActivity.class);
            }
        });
        hotBuyAdapter.setData(dayCrazyList);
        hotBuyAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(hotBuyListView);
    }

    /**
     * 集客推荐
     */
    public void initRecommend() {
        recommendHeader = LayoutInflater.from(context).inflate(R.layout.header_home_base, null);
        TextView title = (TextView) recommendHeader.findViewById(R.id.tv_title);
        title.setText("集客推荐");
        recommendHeader.measure(0, 0);
        recommendListView.addHeaderView(recommendHeader);
        recommendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        recommendAdapter = new RecommendAdapter(context, R.layout.item_recommend);
        recommendListView.setAdapter(recommendAdapter);
        recommendAdapter.setData(dayCrazyList);
        recommendAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(recommendListView);
    }


    /**
     * 每日疯抢
     */
    public void initDayCrazy() {
        dayCrazyHeader = LayoutInflater.from(context).inflate(R.layout.header_home_day_crazy, null);
        dayCrazyHeader.measure(0, 0);
        dayCrazyListView.addHeaderView(dayCrazyHeader);
        dayCrazyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        dayCrazyAdapter = new DayCrazyAdapter(context, R.layout.item_day_crazy);
        dayCrazyListView.setAdapter(dayCrazyAdapter);
        dayCrazyAdapter.setData(dayCrazyList);
        dayCrazyAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(dayCrazyListView);
    }

    /**
     * 计算ListView的高度
     *
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        // 获取ListView对应的Adapter
        if (adapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = adapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = adapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    /**
     * 计算GridView的高度
     *
     * @param gridView
     */
    public void setGridViewHeightBasedOnChildren(GridView gridView) {
        // 获取GridView对应的Adapter
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int rows;
        int columns = 0;
        int horizontalBorderHeight = 0;
        Class<?> clazz = gridView.getClass();
        try {
            //利用反射，取得每行显示的个数
            Field column = clazz.getDeclaredField("mRequestedNumColumns");
            column.setAccessible(true);
            columns = (Integer) column.get(gridView);
            //利用反射，取得横向分割线高度
            Field horizontalSpacing = clazz.getDeclaredField("mRequestedHorizontalSpacing");
            horizontalSpacing.setAccessible(true);
            horizontalBorderHeight = (Integer) horizontalSpacing.get(gridView);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //判断数据总数除以每行个数是否整除。不能整除代表有多余，需要加一行
        if (listAdapter.getCount() % columns > 0) {
            rows = listAdapter.getCount() / columns + 1;
        } else {
            rows = listAdapter.getCount() / columns;
        }
        int totalHeight = 0;
        for (int i = 0; i < rows; i++) { //只计算每项高度*行数
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight + horizontalBorderHeight * (rows - 1);//最后加上分割线总高度
        gridView.setLayoutParams(params);
    }

    /**
     * 初始化popupWindow
     */
    public void initPoppupWindow() {
        isOpen = true;
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.popupwindow_address, null);
        mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(actionBar);

        addressGridView = (GridView) popupView.findViewById(R.id.grid_address);
        addressAdapter = new AddressAdapter(context, R.layout.item_address);
        addressGridView.setAdapter(addressAdapter);

    }


    @Override
    protected void loadData() {
        getImageList();
    }

    /**
     * 菜单
     */
    public void initMenu() {
        ArrayList<MenuBean> arrayList = new ArrayList<>();
        String[] menu = getResources().getStringArray(R.array.home_menu);
        ArrayList<Integer> menuImage = AppConfig.getHomeMenuImage();
        for (int i = 0; i < menu.length; i++) {
            arrayList.add(new MenuBean(menu[i], menuImage.get(i)));
        }
        menuAdapter.setData(arrayList);
    }


    /**
     * 获取banner
     */
    public void getImageList() {
        list = new ArrayList<>();
        Api.getImageList(new ApiHttpClient.ApiHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseBody) {
                scrollView.onRefreshComplete();
                Ad ad = new Gson().fromJson(responseBody, Ad.class);
                ArrayList<String> ads = ad.getImg_list().getAndroid();
                AppConfig.AD_INFOS = new ArrayList<>();

                for (String s : ads) {
                    Banner banner = new Banner();
                    banner.setImg(s);
                    banner.setName(s);
                    list.add(banner);
                }
                header.initData(getImgLoader(), list);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showToast("服务器连接失败");
            }
        });
    }
}
