import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class UserTest {
        public static void main(String[] args) {
            try {
                writeToFile();
                //readFromFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**
         * DOC 往文件里写入数据.
         *
         * @throws IOException
         */
        private static void writeToFile() throws IOException {
            String writerContent = "";// 要写入的文本
            File file = new File("C:\\1212\\el_user_follow.txt");// 要写入的文本文件
            if (!file.exists()) {// 如果文件不存在，则创建该文件
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);// 获取该文件的输出流
            String writerContent2 = "";
            writerContent2 = "follow_id,uid,fid,tid,remark,ctime,type,is_read,is_hide\r\n";
            writer.write(writerContent2);
            for (int i = 1 ;i < 11000; i ++ ) {
//                writerContent = "insert into `user` VALUES ("+"'"+(i + 1)+"'," +"yystrong"+i+"',"+"'111',"
//                        +"'"+calcTime("", -(i+1))+"'"+"'0',"+"'0',"+"'"+calcTime("", -(i+1))+"'"
//                        + "\r\n";
                writerContent =
                        ""+(i + 114274)+"," +"11392212," +(i + 1102921)+","+"0,"
                        +","+"1669791850,"+"2,"+"1,"+"0"
                        + "\r\n";
                writer.write(writerContent);// 写内容
            }
            writer.flush();// 清空缓冲区，立即将输出流里的内容写到文件里
            writer.close();// 关闭输出流，施放资源
        }

        /**
         *
         * @param type 往前计算的类型（week、month、year，“”表示day
         * @param count 往前计算的数量
         * @return
         */
        private static String calcTime(String type ,int count){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            if (type .equals("week")) {
                //周
                calendar.add(Calendar.WEEK_OF_YEAR, count);
            }else if (type .equals("month")) {
                //月
                calendar.add(Calendar.MONTH, count);
            }else if (type .equals("year")) {
                //12个月
                calendar.add(Calendar.MONTH, count);
            }else {
                //日
                calendar.add(Calendar.DATE, count);
            }
            java.util.Date date = calendar.getTime();
            return sdf.format(date);

        }

    }

