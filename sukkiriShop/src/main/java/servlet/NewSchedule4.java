package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/NewSchedule4")
public class NewSchedule4 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=Shift_Jis");
		PrintWriter out = response.getWriter();

		int year;
		int month;
		int day;


		String param = request.getParameter("YEAR");
		if (param == null || param.length() == 0) {
			year = -999;
		}else {
			try {
				year = Integer.parseInt(param);
			}catch(NumberFormatException e) {
				year = -999;
			}
		}

		param = request.getParameter("MONTH");
		if (param == null || param.length() == 0) {
			month = -999;
		}else {
			try {
				month = Integer.parseInt(param);
			}catch (NumberFormatException e) {
				month = -999;
			}
		}

		param = request.getParameter("DAY");
		if (param == null || param.length() == 0) {
			day = -999;
		}else {
			try {
				day = Integer.parseInt(param);
			}catch (NumberFormatException e) {
				day = -999;
			}
		}

        /* パラメータが指定されていない場合は本日の日付を設定 */
		if (year == -999 || month == -999 || day == -999) {
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH);
			day = calendar.get(Calendar.DATE);
		}

		StringBuffer sb = new StringBuffer();

		sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"ja\">");
        sb.append("<head>");
        sb.append("<meta http-equiv=\"Content-Type\" Content=\"text/html;charset=Shift_JIS\">");

        sb.append("<title>スケジュール登録</title>");

        sb.append("<style>");
        sb.append("table.sche{border:1px solid #a9a9a9;padding:0px;margin:0px;border-collapse:collapse;}");
        sb.append("td{vertical-align:top;margin:0px;padding:2px;font-size:0.75em;height:20px;}");
        sb.append("td.top{border-bottom:1px solid #a9a9a9;text-align:center;}");
        sb.append("td.time{background-color:#f0f8ff;text-align:right;border-right:1px double #a9a9a9;padding-right:5px;}");
        sb.append("td.timeb{background-color:#f0f8ff;border-bottom:1px solid #a9a9a9;border-right:1px double #a9a9a9;}");
        sb.append("td.contents{background-color:#ffffff;border-bottom:1px dotted #a9a9a9;}");
        sb.append("td.contentsb{background-color:#ffffff;border-bottom:1px solid #a9a9a9;}");
        sb.append("td.ex{background-color:#ffebcd;border:1px solid #8b0000;}");
        sb.append("img{border:0px;}");
        sb.append("p{font-size:0.75em;}");

        sb.append("#contents{margin:0;padding:0;width:710px;}");

        sb.append("#contents:after{content:\".\";display:block;height:0;clear:both;visibility:hidden;}");
        sb.append("</style>");

        sb.append("</head>");
        sb.append("<body>");

        sb.append("<p>");
        sb.append("スケジュール登録 ");
        sb.append("[<a href=\"/sukkiriShop/MonthView5");
        sb.append("?YEAR=");
        sb.append(year);
        sb.append("&MONTH=");
        sb.append(month);
        sb.append("\">カレンダーへ戻る</a>]");
        sb.append("</p>");

        sb.append("<div id=\"contents\">");



        sb.append("<div id=\"right\">");

        sb.append("<form method=\"post\" action=\"/sukkiriShop/ScheduleInsert1\">");
        sb.append("<table>");
        sb.append("<tr>");

        sb.append("<td nowrap>日付</td>");
        sb.append("<td>");
        sb.append("<select name=\"YEAR\">");
        for (int i = 2022 ; i <= 2030 ; i++) {
        	sb.append("<option value=\"");
        	sb.append(i);
        	sb.append("\"");
        	if (i == year) {
        		sb.append(" selected");
        	}
        	sb.append(">");
        	sb.append(i);
        	sb.append("年");
        }
        sb.append("</select>");

        sb.append("<select name=\"MONTH\">");
        for (int i = 1 ; i <= 12 ; i++) {
        	sb.append("<option value=\"");
        	sb.append(i);
        	sb.append("\"");
        	if (i == (month + 1)) {
        		sb.append(" selected");
        	}
        	sb.append(">");
        	sb.append(i);
        	sb.append("月");
        }
        sb.append("</select>");

        sb.append("<select name=\"DAY\">");
        int monthLastDay = getMonthLastDay(year,month,day);
        for (int i = 1; i <= monthLastDay ; i++) {
        	sb.append("<option value=\"");
        	sb.append(i);
        	sb.append("\"");
        	if (i == day) {
        		sb.append(" selected");
        	}
        	sb.append(">");
        	sb.append(i);
        	sb.append("日");
        }
        sb.append("</selected>");

        sb.append("</td>");
        sb.append("</tr>");


        sb.append("<tr>");
        sb.append("<td nowrap>食欲</td>");
        sb.append("<td><select name=\"APPETITE\">");
        sb.append("<option value=\" \">選択してください</option>");
        sb.append("<option value=\"食欲あり \">あり</option>");
        sb.append("<option value=\"食欲なし \">なし</option>");
        sb.append("</select>");
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td nowrap>うんち</td>");
        sb.append("<td><select name=\"POOP\">");
        sb.append("<option value=\" \">選択してください</option>");
        sb.append("<option value=\"うんち良し \">うんち良し</option>");
        sb.append("<option value=\"うんちワロシ \">うんちワロシ</option>");
        sb.append("</select>");
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td nowrap>鼻水</td>");
        sb.append("<td><select name=\"SNOT\">");
        sb.append("<option value=\" \">選択してください</option>");
        sb.append("<option value=\"鼻水あり \">鼻水あり</option>");
        sb.append("<option value=\"鼻水なし \">鼻水なし</option>");
        sb.append("</select>");
        sb.append("</td>");
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append("<td nowrap>目ヤニ</td>");
        sb.append("<td><select name=\"MUCUS\">");
        sb.append("<option value=\" \">選択してください</option>");
        sb.append("<option value=\"目ヤニあり \">目ヤニあり</option>");
        sb.append("<option value=\"目ヤニなし \">目ヤニなし</option>");
        sb.append("</select>");
        sb.append("</td>");
        sb.append("</tr>");


        sb.append("</table>");

        sb.append("<p>");
        sb.append("<input type=\"submit\" name=\"Register\" value=\"登録する\"> <input type=\"reset\" value=\"リセット\">");
        sb.append("<p>");
        sb.append("</form>");

        sb.append("</div>");
        sb.append("</div>");

        sb.append("</body>");
        sb.append("</html>");

        out.println(new String(sb));
    }

	protected int getMonthLastDay(int year,int month,int day) {
		Calendar calendar = Calendar.getInstance();

		calendar.set(year, month + 1,0);
		int thisMonthlastDay = calendar.get(Calendar.DATE);

		return thisMonthlastDay;

	}

}
