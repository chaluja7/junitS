package cz.cvut.junit.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by frox on 19.4.16.
 */
public class Util {

    public static String readFile(File file){

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object createObjectFromJson(String json, Class<? extends Object> desiredClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, desiredClass);
    }

    public static String createJsonFromObject(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    public static String getDateTimeCsFormat(){
        return "dd.MM.yyyy";
    }

    public static Date getDateFromCsFormat(String dateString) {
        DateFormat df = new SimpleDateFormat(getDateTimeCsFormat());
        try {
            return df.parse(dateString);
        } catch(ParseException e) {
            return null;
        }
    }

    public static String getCsStringFromDate(Date date) {
        DateFormat df = new SimpleDateFormat(getDateTimeCsFormat());
        return  df.format(date);
    }
}
