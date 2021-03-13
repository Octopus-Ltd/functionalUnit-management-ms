package com.octopus.functionalUnitManagement.businessLogic.implementations;

import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityLogic implements IUtilityLogic {

    public String IdGenerator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);

        String splitter[] = strDate.split("-");
        String dater = String.join("", splitter);
        String spliter[] = dater.split(":");
        dater = String.join("", spliter);
        spliter = dater.split(" ");
        dater = String.join("", spliter);

        return dater;
    }
}
