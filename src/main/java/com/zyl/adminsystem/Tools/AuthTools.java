package com.zyl.adminsystem.Tools;


public class AuthTools {

    public static boolean getAuth(int auth,int authType){
        return auth%(authType*2)/authType==1;
    }
}
