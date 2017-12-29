package com.deeshantrajput.olaplaystudios.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.deeshantrajput.olaplaystudios.R;
import com.deeshantrajput.olaplaystudios.utils.FontUtils;

public class TextView extends android.support.v7.widget.AppCompatTextView {


    public TextView(Context context) {
        super(context);
        if (!isInEditMode()){
            applyTypeface(context);
        }
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextView,0,0);
        int style = typedArray.getInteger(R.styleable.TextView_textStyle, FontUtils.BLACK);
        if(!isInEditMode())
            applyTypeface(context,style);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int style = attrs.getStyleAttribute();
        if(!isInEditMode())
            applyTypeface(context,style);
    }

    private void applyTypeface(Context context){
        Typeface BlackTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Black.otf");
        super.setTypeface(BlackTypface);
    }

    public void applyTypeface(Context context, int style){

        Typeface BlackTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Black.otf");
        Typeface BlackItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-BlackItalic.otf");
        Typeface BoldTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Bold.otf");
        Typeface BoldItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-BoldItalic.otf");
        Typeface BookTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Book.otf");
        Typeface BookItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-BookItalic.otf");
        Typeface LightTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Light.otf");
        Typeface LightItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-LightItalic.otf");
        Typeface MediumTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Medium.otf");
        Typeface MediumItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-MediumItalic.otf");
        Typeface ThinTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-Thin.otf");
        Typeface ThinItalicTypface = Typeface.createFromAsset(context.getAssets(),"fonts/Forza-ThinItalic.otf");

        switch (style) {
            case FontUtils.BLACK:super.setTypeface(BlackTypface);
                break;
            case FontUtils.BOLD:super.setTypeface(BoldTypface);
                break;
            case FontUtils.LIGHT:super.setTypeface(LightTypface);
                break;
            case FontUtils.MEDIUM:super.setTypeface(MediumTypface);
                break;
            case FontUtils.THIN:super.setTypeface(ThinTypface);
                break;
            case FontUtils.BLACKITALIC:super.setTypeface(BlackItalicTypface);
                break;
            case FontUtils.BOLDITALIC:super.setTypeface(BoldItalicTypface);
                break;
            case FontUtils.LIGHTITALIC:super.setTypeface(LightItalicTypface);
                break;
            case FontUtils.MEDIUMITALIC:super.setTypeface(MediumItalicTypface);
                break;
            case FontUtils.THINITALIC:super.setTypeface(ThinItalicTypface);
                break;
            case FontUtils.BOOK:super.setTypeface(BookTypface);
                break;
            case FontUtils.BOOKITALIC:super.setTypeface(BookItalicTypface);
                break;
            default:super.setTypeface(BlackTypface);
        }
    }


}
