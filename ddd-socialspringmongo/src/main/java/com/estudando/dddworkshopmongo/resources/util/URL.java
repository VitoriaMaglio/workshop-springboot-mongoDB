package com.estudando.dddworkshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

public class URL {
    // classe utilitária URL com um método para decodificar parâmetro de URL
    public static String decodeParam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, Charset.defaultCharset());
    }}
