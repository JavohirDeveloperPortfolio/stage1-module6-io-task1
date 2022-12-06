package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        String str = "";
        try (FileInputStream in = new FileInputStream(file);) {
            int c;
            int count = 0;
            while ((c = in.read()) != -1){
                if (c == '\n'){
                    count ++;
                    if (count == 1){
                        profile.setName(str.substring(6,str.length() - 1));
                    }
                    if (count == 2){
                        profile.setAge(Integer.parseInt(str.substring(5,str.length() - 1)));
                    }
                    if (count == 3){
                        profile.setEmail(str.substring(7,str.length() - 1));
                    }
                    if (count == 4){
                        profile.setPhone(Long.parseLong(str.substring(7,str.length() - 1)));
                    }
                    str = "";
                }else{
                    str += (char)c;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
