package dev.joakimbagge.parser;

import java.util.HashMap;
import java.util.Map;

public class UrlParameterParser {

    private UrlParameterParser() {
    }
    public static Map<String, String> parseParameters(String paramString) {
        Map<String, String> paramMap = new HashMap<>();
        if (paramString == null || paramString.isEmpty()) return paramMap;

        for (String param : paramString.split("&")) {
            String[] keyValue = param.split("=");
            paramMap.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
        }
        return paramMap;
    }
}
