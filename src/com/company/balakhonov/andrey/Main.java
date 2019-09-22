package com.company.balakhonov.andrey;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String inputPath = reader.readLine();
        String filePath = "/home/robot-user/idea-workspace/Words/text.txt";

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
//            fileReader = new FileReader(inputPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<String> list = new ArrayList<>();
        String strBuff = "";
        int data;

        //поиск слов в файле
        while ((data = fileReader.read()) != -1) {
            if (data == ' ' || data == ',' || data == '.') {
                if (strBuff.length() > 0) {
                    list.add(strBuff);
                    strBuff = "";
                }
            } else {
                strBuff += (char) data;
            }
        }

//        list.removeIf(str -> str.length() == 0);
        Collections.sort(list);
        list.forEach(str -> System.out.println(str));

        System.out.println("===============================================");

        HashMap<String, Integer> map = new HashMap<>();

        //подсчёт кол-ва повторений слов
        for (String str : list) {
            int count = 0;

            for (String item : list) {
                if (str.equals(item)) {
                    count++;
                }
            }
            map.put(str, count);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + '\t' + entry.getValue());
        }

        System.out.println("===============================================");

        //поиск чаще всего встречающихся слов
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
           if (max < entry.getValue()) {
               max = entry.getValue();
           }
        }

        System.out.println("Слово(а), встречающиеся чаще всего:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + '\t' + entry.getValue());
            }
        }
    }
}
