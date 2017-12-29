package com.deeshantrajput.olaplaystudios.utils;

import android.graphics.Typeface;

import com.deeshantrajput.olaplaystudios.activities.Application;

public class FontUtils {

    public static final int BLACK = 1;
    public static final int BLACKITALIC = 2;
    public static final int BOLD = 3;
    public static final int BOLDITALIC = 4;
    public static final int BOOK = 5;
    public static final int BOOKITALIC = 6;
    public static final int LIGHT = 7;
    public static final int LIGHTITALIC = 8;
    public static final int MEDIUM = 9;
    public static final int MEDIUMITALIC = 10;
    public static final int THIN = 11;
    public static final int THINITALIC = 12;

    public static Typeface getBlackTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Black.otf");
    }

    public static Typeface getBlackItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-BlackItalic.otf");
    }

    public static Typeface getBoldTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Bold.otf");
    }

    public static Typeface getBoldItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-BoldItalic.otf");
    }

    public static Typeface getBookTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Book.otf");
    }

    public static Typeface getBookItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-BookItalic.otf");
    }

    public static Typeface getLightTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Light.otf");
    }

    public static Typeface getLightItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-LightItalic.otf");
    }

    public static Typeface getMediumTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Medium.otf");
    }

    public static Typeface getMediumItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-MediumItalic.otf");
    }

    public static Typeface getThinTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-Thin.otf");
    }

    public static Typeface getThinItalicTypeface(){
        return Typeface.createFromAsset(Application.getContext().getAssets(),"fonts/Forza-ThinItalic.otf");
    }


}
