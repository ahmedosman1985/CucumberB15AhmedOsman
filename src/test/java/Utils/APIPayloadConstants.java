package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    //we will pass the body in multiple formats, for this we have created this class

   public static String createEmployeePayload(){
        String createEmployeePayLoad = "{\n" +
           "  \"emp_firstname\": \"Ahmed\",\n" +
           "  \"emp_lastname\": \"Osman\",\n" +
           "  \"emp_middle_name\": \"Mosaad Mohamed\",\n" +
           "  \"emp_gender\": \"M\",\n" +
           "  \"emp_birthday\": \"1985-04-29\",\n" +
           "  \"emp_status\": \"Confirmed\",\n" +
           "  \"emp_job_title\": \"Engineer\"\n" +
           "}";
        return createEmployeePayLoad;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Ahmed");
        obj.put("emp_lastname", "Osman");
        obj.put("emp_middle_name", "Mosaad Mohamed");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1985-04-29");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Engineer");
        return obj.toString();
    }
    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }
    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_id","54105A");
        obj.put("emp_firstname","natalia");
        obj.put("emp_lastname","glusco");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2011-04-22");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }

}
