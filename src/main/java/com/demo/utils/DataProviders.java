package com.demo.utils;

import com.demo.models.RegistrationUser;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> registration() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olga", "Straus", "hatip457@insfou.com", "Ab!122aaaaaaaaa222345", "Ab!122aaaaaaaaa222345"});
        list.add(new Object[]{"Olga", "Straus", "hatip457@i.com", "Ab!1111112345", "Ab!1111112345"});
        list.add(new Object[]{"Olga", "Straus", "hatip457@insfou.com", "Ab!1ab", "Ab!1ab"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registration.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new RegistrationUser().setFirstName(split[0])
                    .setLastName(split[1]).setEmail(split[2]).setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
