package com.hp.curriculum.model.constant.enumerate;

import com.hp.curriculum.model.exception.enumerate.EnumException;
import com.hp.curriculum.model.exception.enumerate.EnumValueOutOfBounds;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/6/8
 */
@AllArgsConstructor
@Getter
public enum No {
    /**
     * 一到二十班
     */
    FIRST("1班"),
    SECOND("2班"),
    THIRD("3班"),
    FOURTH("4班"),
    FIFTH("5班"),
    SIXTH("6班"),
    SEVENTH("7班"),
    EIGHTH("8班"),
    NINE("9班"),
    TEN("10班"),
    ELEVEN("11班"),
    TWELVE("12班"),
    THIRTEEN("13班"),
    FOURTEEN("14班"),
    FIFTEEN("15班"),
    SIXTEEN("16班"),
    SEVENTEEN("17班"),
    EIGHTEEN("18班"),
    NINETEEN("19班"),
    TWENTY("20班");

    private static final No[] ENUMS = No.values();
    private String displayName;

    public static No of(int no) throws EnumException {
        if (no < 0 || no > 20) {
            throw new EnumValueOutOfBounds("Invalid value for No: " + no);
        }
        return ENUMS[no - 1];
    }
}
