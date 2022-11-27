package com.example.demomini.Controller;
import com.example.demomini.Bean.Course;
import com.example.demomini.Bean.Course_Schedule;
import com.example.demomini.DAO.DAOImplementation.DomainDAOImpl;
import com.example.demomini.DAO.DomainDAO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

public class GetSchedule {
    public JSONArray getCourseSchedule(int domainId){
        DomainDAO g = new DomainDAOImpl();
        List<Course> courses = g.getCoursesByDomain(domainId);
        String[][] schedule = new String[4][5];
        //Arrays.fill(schedule,"");
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("MON",0);
        hashMap.put("TUE",1);
        hashMap.put("WED",2);
        hashMap.put("THU",3);
        hashMap.put("FRI",4);
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                schedule[i][j]="";
            }
        }
        for(Course course:courses){
                List<Course_Schedule> courseSchedules = course.getCourseSchedules();
                System.out.println("asd"+courseSchedules.size());
                for(Course_Schedule courseSchedule : courseSchedules){
                    Time time = courseSchedule.getTime();
                    String timeStr = time.toString();
                    switch(timeStr) {
                        case "09:30:00":
                            schedule[0][hashMap.get(courseSchedule.getDay())] = course.getCourse_name()+"("+courseSchedule.getRoom()+")";
                            break;
                        case "11:30:00":
                            schedule[1][hashMap.get(courseSchedule.getDay())] = course.getCourse_name()+"("+courseSchedule.getRoom()+")";
                            break;
                        case "14:30:00":
                            schedule[2][hashMap.get(courseSchedule.getDay())] = course.getCourse_name()+"("+courseSchedule.getRoom()+")";
                            break;
                        case "16:30:00":
                            schedule[3][hashMap.get(courseSchedule.getDay())] = course.getCourse_name()+"("+courseSchedule.getRoom()+")";
                            break;
                    }
                }


        }

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for(int i=0;i<4;i++){
            jsonObject = new JSONObject();
            jsonObject.put("MON",schedule[i][0]);
            jsonObject.put("TUE",schedule[i][1]);
            jsonObject.put("WED",schedule[i][2]);
            jsonObject.put("THU",schedule[i][3]);
            jsonObject.put("FRI",schedule[i][4]);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
