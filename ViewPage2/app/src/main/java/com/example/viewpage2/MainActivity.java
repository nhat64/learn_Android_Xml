package com.example.viewpage2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer2;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Lấy các view
        circleIndicator3 = findViewById(R.id.indicator);
        viewPager2 = findViewById(R.id.viewPage2);
        // khai báo vài thuộc tính trước
//        viewPager2.setClipChildren(false);
//        viewPager2.setClipToPadding(false);
        viewPager2.setOffscreenPageLimit(5);
        // chọn demo, slide ảnh thì phải đặt padding bên activity cho viewPager2, flipbook thì xóa padding đi
//        setSlide();
        setFlipBook();

        circleIndicator3.setViewPager(viewPager2);
    }

    public void setFlipBook(){
        BookFlipPageTransformer2 bookFlipPageTransformer2 = new BookFlipPageTransformer2();
        // Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
        bookFlipPageTransformer2.setEnableScale(true);
        // The amount of scale the page will zoom. By default, its 5 percent.
        bookFlipPageTransformer2.setScaleAmountPercent(10f);

        viewPager2.setPageTransformer(bookFlipPageTransformer2);

        UseRecyclerViewAdapter useRecyclerViewAdapter = new UseRecyclerViewAdapter(getPages());
        viewPager2.setAdapter(useRecyclerViewAdapter);

    }

    public void setSlide() {
        /*
        Muốn nó hiển thị nhiều thì phải padding để ép cái view hiển thị nhỏ lại: !!!!!!!!!!!!!!!!!!!!
        Tưởng tượng cái cửa sổ viewPager2, một fragment đang hiển thị với width match_parent
        mấy fragment khác đã được tạo sẵn sàng ở hai bên nhưng chúng không thể hiển thị do fragment
        chính đang có widdth match_parent che khuất, dùng padding cho của sổ viewPager2 sẽ khiến
        không gian fragment chính có thể hiển thị nhỏ lại, khi đó những fragment đã sẵn sàng ở hai
        bên có thể được nhìn thấy, do chưa được hiển thị như fragment chính nên chúng ở ngay sát fragment
        chính, margin giữa chúng được set bằng MarginTranformer.
        */

        MarginPageTransformer transformer = new MarginPageTransformer(80);

        viewPager2.setPageTransformer(transformer);
        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                if(position == 0){
                    page.setScaleY(1.05f);
                    page.setScaleX(1.05f);
                }else{
                    page.setScaleY(0.85f);
                    page.setScaleX(0.85f);
                }
            }
        });

        UseFragmentSateAdapter useFragmentSateAdapter = new UseFragmentSateAdapter(this, getPages());
        viewPager2.setAdapter(useFragmentSateAdapter);
    }

    public ArrayList<Page> getPages(){
        ArrayList<Page> list = new ArrayList<Page>();
        list.add(new Page(R.drawable.page1));
        list.add(new Page(R.drawable.page2));
        list.add(new Page(R.drawable.page3));
        list.add(new Page(R.drawable.page4));
        list.add(new Page(R.drawable.page5));
        list.add(new Page(R.drawable.page6));
        list.add(new Page(R.drawable.page7));
        list.add(new Page(R.drawable.page8));
        return list;
    }
}