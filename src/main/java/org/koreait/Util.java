package org.koreait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class Util {

    public static String Date(){
        LocalDateTime localDateTime = LocalDateTime.now();

        String localDateTimeFormat
                = localDateTime.format(
                DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
        );

        return localDateTimeFormat;

    }


}
