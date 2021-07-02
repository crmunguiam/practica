package api.v1.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static String devuelveFormatoFecha(String fecha) {
        String anio = fecha.substring(0, 4);
        String mes = fecha.substring(4, 6);
        String dia = fecha.substring(6, 8);
        String patron = "%s-%s-%s";
        return String.format(patron, anio, mes, dia);

    }


    public static  Date formatFecha(String fecha) throws ParseException {
        String fechaF =devuelveFormatoFecha( fecha);
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date date = format.parse(fechaF);
        System.out.println(date);
        return date;
    }
}
