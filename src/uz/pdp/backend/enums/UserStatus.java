package uz.pdp.backend.enums;

import java.util.StringJoiner;

public enum UserStatus {
    ACTIVE,
    BLOCKED;

    public static String getList(){
        UserStatus[] values = values();
        StringJoiner joiner = new StringJoiner("\n","=".repeat(10)+"\n","");
        for (UserStatus value : values) {
            joiner.add((value.ordinal()+1)+". "+value);
        }
        return joiner.toString();
    }
    public static UserStatus getCategoryByOrdinal(int ordinal){
        UserStatus[] values = values();
        for (UserStatus value : values) {
            if (value.ordinal()==(ordinal-1)) return value;
        }
        return null;
    }
}
