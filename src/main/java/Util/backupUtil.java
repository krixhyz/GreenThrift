package Util;

import java.io.*;
import java.sql.SQLException;

public class backupUtil {
    private static final String DB_NAME = "coursework";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String BACKUP_PATH = "backups/";

    public static boolean backupDatabase(String backupFileName) {
        try {
            File backupDir = new File(BACKUP_PATH);
            if (!backupDir.exists()) {
                backupDir.mkdirs();
            }
            String command = String.format("mysqldump -u%s -p%s %s > %s%s",
                    DB_USER, DB_PASSWORD, DB_NAME, BACKUP_PATH, backupFileName);
            Process process = Runtime.getRuntime().exec(command);
            return process.waitFor() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean restoreDatabase(String backupFileName) {
        try {
            String command = String.format("mysql -u%s -p%s %s < %s%s",
                    DB_USER, DB_PASSWORD, DB_NAME, BACKUP_PATH, backupFileName);
            Process process = Runtime.getRuntime().exec(command);
            return process.waitFor() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}