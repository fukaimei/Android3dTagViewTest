package net.fkm.android3dtagview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moxun.tagcloudlib.view.TagCloudView;

import net.fkm.android3dtagview.adapte.TagCloudViewAdapter;
import net.fkm.android3dtagview.model.StarModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mTagCloudView)
    TagCloudView mTagCloudView;

    private TagCloudViewAdapter mTagCloudViewAdapter;
    private List<StarModel> mStarModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 获取用户数据
        getData();

        // 设置适配器数据
        mTagCloudViewAdapter = new TagCloudViewAdapter(this, mStarModelList);
        mTagCloudView.setAdapter(mTagCloudViewAdapter);

        // 设置 3d Tag View 条目点击事件
        mTagCloudView.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {
                String userId = mStarModelList.get(position).getUserId();
                String nickName = mStarModelList.get(position).getNickName();
                Toast.makeText(MainActivity.this, String.format("用户id：%s；用户昵称：%s", userId, nickName), Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * 模拟从网络获取100条用户数据
     */
    private void getData() {

        if (mStarModelList != null) mStarModelList.clear();
        for (int i = 0; i < 100; i++) {
            StarModel data = new StarModel();
            data.setUserId("" + i);
            data.setNickName("彼岸雨敲窗" + i);
            data.setPhotoUrl("https://fukaimei.oss-cn-beijing.aliyuncs.com/images/ic_user.png?x-oss-process=style/thumb");
            mStarModelList.add(data);
        }

    }

}