package Controller;

import Util.backupUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/backup")
public class BackupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message;

        if ("backup".equals(action)) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String backupFile = "backup_" + timestamp + ".sql";
            if (backupUtil.backupDatabase(backupFile)) {
                message = "Backup created successfully: " + backupFile;
            } else {
                message = "Backup failed.";
            }
        } else if ("restore".equals(action)) {
            String backupFile = request.getParameter("backupFile");
            if (backupUtil.restoreDatabase(backupFile)) {
                message = "Database restored successfully.";
            } else {
                message = "Restore failed.";
            }
        } else {
            message = "Invalid action.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
    
}
