package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        StringBuilder str = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)) {
            int c, count = 0;
            while ((c = in.read()) != -1){
                if (c == '\n'){
                    System.out.println(str);
                    count ++;
                    switch (count){
                        case 1:profile.setName(str.substring(6,str.length() - 1));break;
                        case 2:profile.setAge(Integer.parseInt(str.substring(5,str.length() - 1)));break;
                        case 3:profile.setEmail(str.substring(7,str.length() - 1));break;
                        case 4:profile.setPhone(Long.parseLong(str.substring(7,str.length() - 1)));break;
                    }
                    System.out.println(str + " | " + profile);
                    str = new StringBuilder();
                }else{
                    str.append((char) c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
