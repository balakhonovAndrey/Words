package com.company.balakhonov.andrey;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filePath = "/home/robot-user/idea-workspace/Words/text.txt";
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<String> list = new ArrayList<>();
        String strBuff = "";
        int data;

        while ((data = fileReader.read()) != -1) {
            if (data == ' ' || data == ',' || data == '.') {
                list.add(strBuff);
                strBuff = "";
            } else {
                strBuff += (char) data;
            }
        }

        list.removeIf(str -> str.length() == 0);
        Collections.sort(list);
//        list.forEach(str -> System.out.println(str));

        System.out.println("===============================================");

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : list) {
            int count = 0;

            for (String item : list) {
                if (str.equals(item)) {
                    count++;
                }
            }
            map.put(str, count);
        }

        for (Map.Entry<String, Integer > entry: map.entrySet()) {
            String  key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + '\t' + value);
        }

    }
}
