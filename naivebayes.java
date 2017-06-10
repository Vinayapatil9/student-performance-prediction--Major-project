
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class naivebayes
{
    public static void main(String[] args) {
        double hsc=0, ssc=0, cet=0, pyesssc, pnossc, pyeshsc, pnohsc, pyescet, pnocet, pyestraveltime, pnotraveltime, pyesattendance,
                pnoattendance, pyesUNITTEST, pnoUNITTEST;
        double pyesURESULT, pnoURESULT, pyesclass, pnoclass,pfinalyes, pfinalno, attendance=0, UNITTEST=0, URESULT=0;
        double totalno, totalyes;
        double ssc_yes_count, hsc_yes_count, cet_yes_count, traveltime_yes_count, attendance_yes_count, UNITTEST_yes_count, URESULT_yes_count, ssc_no_count;
        double hsc_no_count, cet_no_count, traveltime_no_count, attendance_no_count, UNITTEST_no_count, URESULT_no_count;
        float traveltime=0;
        String temph;

        System.out.println("Program for Naive Bayes Clasification");

        System.out.println("Enter The Students data:");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter The ssc Marks in Percentage:");
            temph = in.readLine();
            ssc = Float.parseFloat(temph);

            System.out.println("Enter The hsc Marks in Percentage:");
            temph = in.readLine();
            hsc = Float.parseFloat(temph);


            System.out.println("Enter The  cet marks out of 200:");
            temph = in.readLine();
            cet = Float.parseFloat(temph);
            
            System.out.println("Enter The traveltime:");
            temph = in.readLine();
            traveltime = Float.parseFloat(temph);


            System.out.println("Enter The Attendance in percentage:");
            temph = in.readLine();
            attendance = Float.parseFloat(temph);

            System.out.println("Enter The unit test result in Percentage:");
            temph = in.readLine();
            UNITTEST = Float.parseFloat(temph);

            System.out.println("Enter The university result in Percentage:");
            temph = in.readLine();
            URESULT = Float.parseFloat(temph);


        } catch (Exception e) {
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = con.createStatement();
            String query = null;
            ResultSet rs = null;

//ssc validations
            String sscRange = "";
            if (ssc < 35 || ssc > 100) {
                System.out.println("INvalid ssc MArks");
            }

            if (ssc >= 35 && ssc <= 60) {
                //hscRange = "low";

                sscRange="ssc between 45.00 AND  60.00";
            }

            if (hsc > 60 && hsc < 75) {
                //hscRange = "medium";
                sscRange="ssc between  60 AND  75";
            }

            if (hsc >= 76 && hsc <= 100) {
                //hscRange = "high";
                sscRange="ssc between  76 AND  100";
            }


            // hsc validations
            String hscRange = "";
            if (hsc < 35 || hsc > 100) {
                System.out.println("INvalid HSC MArks");
            }

            if (hsc >= 35 && hsc <= 60) {
                //hscRange = "low";

                hscRange="hsc between  45 AND  60";
            }

            if (hsc > 60 && hsc < 75) {
                //hscRange = "medium";
                hscRange="hsc between  60 AND  75";
            }

            if (hsc >= 76 && hsc <= 100) {
                //hscRange = "high";
                hscRange="hsc between  76 AND  100";
            }

            //cet validations

            String cetRange = "";

            if (cet < 45) {
                System.out.println("INvalid cet MArks");
            }

            if (cet >= 45 && cet <= 60) {
               /* cetRange = "low";*/

                cetRange="cet between  45 AND  60";
            }

            if (cet >= 61 && cet <= 124) {
                // cetRange = "medium";
                cetRange="cet between  61 AND  124 ";
            }

            if (cet >= 125 && cet <= 200) {
                //cetRange = "high";
                cetRange="cet between  125 AND  200 ";
            }

            // traveltime validations


            String ttRange = "";

            if (traveltime >=4) {
                System.out.println("INvalid Travel time");
            }

            if (traveltime >= 0 && traveltime <= 1) {
                /*ttRange = "low";*/
                ttRange="traveltime between  0 AND  1";
            }

            if (traveltime >= 1.01 && traveltime <= 3) {
                /*ttRange = "medium";*/
                ttRange="traveltime BETWEEN 1.01 AND  3";
            }

            if (traveltime >= 3.01 && traveltime <= 4) {
                /*ttRange = "high";*/
                ttRange="traveltime between 3.01 AND traveltime  4";


            }



// attendance validations


            String attendanceRange = "";
            if (attendance >= 0 && attendance <= 14.99) {
                System.out.println("Invalid attendance");
            }

            if (attendance >= 15 && attendance <= 40) {
                //attendanceRange = "low";
                attendanceRange="attendance between  15 AND  40";
            }

            if (attendance > 40 && attendance <= 75) {
                //  attendanceRange = "medium";
                attendanceRange="attendance between  40 AND  75";
            }

            if (attendance > 75 && attendance <= 100) {
                //attendanceRange = "high";
                attendanceRange="attendance between  75 AND  100";
            }
// utest validations
            String UNITTESTRange = "";
            if (UNITTEST < 40 || UNITTEST > 100) {
                System.out.println("INvalid UNITTEST MArks");
            }

            if (UNITTEST >= 40 && UNITTEST <= 60) {
                //UNITTESTRange = "low";

                UNITTESTRange="UNITTEST between  40 AND  60";
            }

            if (UNITTEST > 61 && UNITTEST <= 75) {
                //UNITTESTRange = "medium";
                UNITTESTRange="UNITTEST between  61 AND  75";
            }

            if (UNITTEST >= 76 && UNITTEST <= 100) {

                //UNITTESTRange = "high";
                UNITTESTRange="UNITTEST between  76 AND  100";

            }


            // University Resultpercent validations
            String URESULTRange = " ";
            if (URESULT < 40 || URESULT > 100) {
                System.out.println("INvalid University Result");
            }

            if (URESULT >= 46 && URESULT <= 60) {
                //hscRange = "low";
                URESULTRange="URESULT between  46 AND  60";
            }

            if (URESULT > 61 && URESULT < 75) {
                //hscRange = "medium";
                URESULTRange="URESULT between  61 AND  75";

            }

            if (URESULT >= 76 && URESULT <= 100) {
                //hscRange = "high";
                URESULTRange="URESULT between  61 AND  75";
            }


//Fetch values from Database

            rs = stmt.executeQuery("Select count(ssc) from analysis where class='yes' and " +sscRange);
            rs.next();
            ssc_yes_count= rs.getInt(1);

            rs = stmt.executeQuery("select count(hsc) from analysis where class='yes' and " +hscRange);
            rs.next();
            hsc_yes_count=rs.getInt(1);

            rs = stmt.executeQuery("select count(cet) from analysis where class='yes' and " +cetRange);
            rs.next();
            cet_yes_count=rs.getInt(1);

            rs = stmt.executeQuery("select count(attendance) from analysis where class='yes' and " +attendanceRange);
            rs.next();
            attendance_yes_count=rs.getInt(1);

            rs = stmt.executeQuery("select count(traveltime) from analysis where class='yes' and "+ttRange);
            rs.next();
            traveltime_yes_count=rs.getInt(1);

            //System.out.println("TTy: "+traveltime_yes_count);
            rs = stmt.executeQuery("select count(UNITTEST) from analysis where class='yes'and " +UNITTESTRange);
            rs.next();
            UNITTEST_yes_count = rs.getInt(1);

            rs = stmt.executeQuery("select count(URESULT) from analysis where class='yes'and " +URESULTRange);
            rs.next();
            URESULT_yes_count = rs.getInt(1);



            rs = stmt.executeQuery("select count(ssc) from analysis where class='no' and " +sscRange);
            rs.next();
            ssc_no_count = rs.getInt(1);


            rs = stmt.executeQuery("select count(hsc) from analysis where class='no' and "  +hscRange);
            rs.next();
            hsc_no_count = rs.getInt(1);

            rs = stmt.executeQuery("select count(cet) from analysis where class='no' and " +cetRange);
            rs.next();
            cet_no_count = rs.getInt(1);

            rs = stmt.executeQuery("select count(attendance) from analysis where class='no' and " +attendanceRange);
            rs.next();
            attendance_no_count=rs.getInt(1);

            rs = stmt.executeQuery("select count(traveltime) from analysis where class='no' and  " +ttRange);
            rs.next();
            traveltime_no_count = rs.getInt(1);
            //System.out.println("TT: "+traveltime_no_count);

            rs = stmt.executeQuery("select count(UNITTEST) from analysis where class='no' and " +UNITTESTRange);
            rs.next();
            UNITTEST_no_count = rs.getInt(1);


            rs = stmt.executeQuery("select count(URESULT) from analysis where class='no' and " +URESULTRange);
            rs.next();
            URESULT_no_count = rs.getInt(1);







            rs = stmt.executeQuery("select count(*) from analysis where class='yes'");
            rs.next();
            totalyes = rs.getInt(1);

            rs = stmt.executeQuery("select count(*) from analysis where class='no'");
            rs.next();
            totalno = rs.getInt(1);





            //Apply the formulas

            pyesssc = ssc_yes_count / totalyes;
            pnossc = ssc_no_count / totalno;

            pyeshsc = hsc_yes_count / totalyes;
            pnohsc = hsc_no_count / totalno;

            pyescet = cet_yes_count / totalyes;
            pnocet = cet_no_count / totalno;


            pyestraveltime = traveltime_yes_count / totalyes;
            pnotraveltime = traveltime_no_count / totalno;

            pyesattendance = attendance_yes_count / totalyes;
            pnoattendance = attendance_no_count / totalno;

            pyesUNITTEST = UNITTEST_yes_count / totalyes;
            pnoUNITTEST = UNITTEST_no_count / totalno;


            pyesURESULT = URESULT_yes_count / totalyes;
            pnoURESULT = URESULT_no_count / totalno;


//main formulas


            pyesclass = pyesssc * pyeshsc * pyescet * pyestraveltime * pyesattendance * pyesUNITTEST * pyesURESULT;

            pnoclass = pnossc * pnohsc * pnocet * pnotraveltime * pnoattendance * pnoUNITTEST * pnoURESULT;


            pfinalyes = pyesclass / (pyesclass + pnoclass);
            pfinalno = pnoclass / (pyesclass + pnoclass);


            if (pfinalyes > pfinalno) {
                System.out.println("Probablistically Student will become an Engineer");
            }
            if (pfinalyes < pfinalno) {
                System.out.println("Probablistically Student will not become an Engineer");

            }

        }



        catch(Exception e)
        {
        	
        	System.out.println("Invalid Student details has been entered,Please Enter Input enter details again.");
            System.out.println("Exception:" + e);
        	
        }


    }
}
