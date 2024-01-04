package com.example.rent_apartment.service.impl;

import java.util.Base64;

public class Base64Manager {

    public static String apartmentDecoder(String value){

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(value);
        return new String(decode);
    }
}
