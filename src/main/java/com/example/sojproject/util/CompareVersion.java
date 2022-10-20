package com.example.sojproject.util;

public class CompareVersion {

    public static int compare(String version1, String version2) {
        int result = 0;
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        Integer maxLengthOfVersions = Math.max(version1Array.length, version2Array.length);
        for(int i=0; i<maxLengthOfVersions; i++) {
            Integer v1 = i < version1Array.length ? Integer.parseInt(version1Array[i]) : 0;
            Integer v2 = i < version2Array.length ? Integer.parseInt(version2Array[i]) : 0;
            int compareResult = v1.compareTo(v2);
            if (compareResult != 0) {
                result = compareResult;
                break;
            }
        }
        return result;
    }

}
