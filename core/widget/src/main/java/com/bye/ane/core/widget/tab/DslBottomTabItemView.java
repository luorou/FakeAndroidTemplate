package com.bye.ane.core.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import com.bye.ane.core.widget.R;


/**
 *
 */
public class DslBottomTabItemView extends FrameLayout {
    private Context context;

    private TextView tvTitle;

    private AppCompatImageView ivIcon;

    private Drawable normalIcon;//普通状态图标的资源id
    private Drawable selectedIcon;//选中状态图标的资源id

    private Drawable blackModeNormalIcon;//普通状态图标的资源id
    private Drawable blackModeSelectedIcon;//选中状态图标的资源id

    private String title;//文本
    private int titleNormalColor;    //描述文本的默认显示颜色
    private int titleSelectedColor;  //述文本的默认选中显示颜色

    private int blackModeTitleNormalColor;    //描述文本的默认显示颜色
    private int blackModeTitleSelectedColor;  //述文本的默认选中显示颜色


    public DslBottomTabItemView(@NonNull Context context) {
        super(context);
    }

    public DslBottomTabItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DslBottomTabItemView);

        initAttrs(ta); //初始化属性

        ta.recycle();

//        checkValues();//检查值是否合法

        init();//初始化相关操作
    }

    public DslBottomTabItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DslBottomTabItemView);

        initAttrs(ta); //初始化属性

        ta.recycle();

//        checkValues();//检查值是否合法

        init();//初始化相关操作
    }

    public DslBottomTabItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DslBottomTabItemView);
        initAttrs(ta); //初始化属性
        ta.recycle();
        init();//初始化相关操作

    }


    private void initAttrs(TypedArray ta) {
        normalIcon = ta.getDrawable(R.styleable.DslBottomTabItemView_iconNormal);
        selectedIcon = ta.getDrawable(R.styleable.DslBottomTabItemView_iconSelected);
        blackModeNormalIcon = ta.getDrawable(R.styleable.DslBottomTabItemView_blackModeIconNormal);
        blackModeSelectedIcon = ta.getDrawable(R.styleable.DslBottomTabItemView_blackModeIconSelected);
        title = ta.getString(R.styleable.DslBottomTabItemView_itemText);
        titleNormalColor = ta.getColor(R.styleable.DslBottomTabItemView_textColorNormal,
                ContextCompat.getColor(context, com.bye.ane.core.resources.R.color.col_bbbbbb));
        titleSelectedColor = ta.getColor(R.styleable.DslBottomTabItemView_textColorSelected,
                ContextCompat.getColor(context, com.bye.ane.core.resources.R.color.col_333333));
        //
        blackModeTitleNormalColor = ta.getColor(R.styleable.DslBottomTabItemView_blackModeTextColorNormal,
                ContextCompat.getColor(context, com.bye.ane.core.resources.R.color.col_bbbbbb));
        blackModeTitleSelectedColor = ta.getColor(R.styleable.DslBottomTabItemView_blackModeTextColorSelected,
                ContextCompat.getColor(context, com.bye.ane.core.resources.R.color.col_333333));

    }

    /**
     *
     */
    private void init() {
        View view = initView();
        tvTitle.setText(title);
        tvTitle.setTextColor(titleNormalColor);
        ivIcon.setImageDrawable(normalIcon);
        addView(view);
    }


    //
    private View initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_dsl_bottom_tab_item_view, null, false);
        tvTitle = view.findViewById(R.id.tv_title);
        ivIcon = view.findViewById(R.id.iv_icon);
        return view;
    }


    /**
     * @param selected
     * @param mode
     */
    public void refreshStatus(boolean selected, ColorMode mode) {

        if (selected) {
            if (mode == ColorMode.BLACK) {
                tvTitle.setTextColor(blackModeTitleSelectedColor);
                ivIcon.setImageDrawable(blackModeSelectedIcon);
            } else {
                tvTitle.setTextColor(titleSelectedColor);
                ivIcon.setImageDrawable(selectedIcon);
            }
        } else {
            if (mode == ColorMode.BLACK) {
                tvTitle.setTextColor(blackModeTitleNormalColor);
                ivIcon.setImageDrawable(blackModeNormalIcon);
            } else {
                tvTitle.setTextColor(titleNormalColor);
                ivIcon.setImageDrawable(normalIcon);
            }
        }

    }
}
