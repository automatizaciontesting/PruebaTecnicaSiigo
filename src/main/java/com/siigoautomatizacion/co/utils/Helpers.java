package com.siigoautomatizacion.co.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helpers {

    public String fechaHoy(String formato) {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        Date date = new Date();
        return formatter.format(date);
    }

    public String fechaPosterior(String formato, int dias) {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, dias);
        Date currentDatePlus = c.getTime();
        return formatter.format(currentDatePlus);

    }
}
