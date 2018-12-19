/*package com.tcs.tt.view;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import com.tcs.tt.domain.TimeEffort;
import com.tcs.tt.service.LogEffortsService;

public class ExcelView extends AbstractXlsView{
	
	private final LogEffortsService effortService;
	
	@Inject
	public ExcelView(final LogEffortsService effortService) {
		this.effortService = effortService;
	
	}

    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<TimeEffort> efforts =  effortService.getList();

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Effort Details");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Task Description");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Effort");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Effort Date");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Created Date");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("is OOO");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("JIRA ID");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("EPIC ID");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Employee No");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Project ID");
        header.getCell(8).setCellStyle(style);



        int rowCount = 1;

        for(TimeEffort effort : efforts){
            Row userRow =  sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(effort.getTaskDescription());
            userRow.createCell(1).setCellValue(effort.getEffort());
            userRow.createCell(2).setCellValue(effort.getEffortDate());
            userRow.createCell(3).setCellValue(effort.getCreatedDate());
            userRow.createCell(4).setCellValue(effort.isOutofOffice());
            userRow.createCell(5).setCellValue(effort.getJiraId());
            userRow.createCell(6).setCellValue(effort.getEpicId());
            userRow.createCell(7).setCellValue(effort.getEmployeeNo());
            userRow.createCell(8).setCellValue(effort.getProjectId());

            }

    }

}
*/