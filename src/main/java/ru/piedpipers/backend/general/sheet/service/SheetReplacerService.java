package ru.piedpipers.backend.general.sheet.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.piedpipers.backend.database.model.base.User;
import ru.piedpipers.backend.database.model.entity.Company;
import ru.piedpipers.backend.general.sheet.util.ExcelBookUtil;
import ru.piedpipers.backend.general.sheet.util.ExcelSheetUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SheetReplacerService {

    private final ExcelBookUtil bookUtil;
    private final ExcelSheetUtil sheetUtil;

    public void replace10(User user) {

        Company company = user.getCompany();
        try {
            FileInputStream file = new FileInputStream("C:/Users/Nikita/OneDrive/Рабочий стол/files/example100.xlsx");

            Optional<XSSFWorkbook> sheets = bookUtil.loadBook(file);
            if (sheets.isEmpty()) return;

            XSSFSheet sheet = sheets.get().getSheetAt(0);
            XSSFRow row = sheetUtil.getRow(sheet, 59);
            XSSFCell cell = sheetUtil.getCell(row, 5);
            cell.setCellValue(company.getTitle());

            XSSFRow row2 = sheetUtil.getRow(sheet, 61);
            XSSFCell cell2 = sheetUtil.getCell(row2, 1);

            String result = cell2.toString()
                    .replace("OGRN_NUMBER", company.getOgrn())
                    .replace("INN_NUMBER", company.getInn())
                    .replace("KPP_NUMBER", company.getKpp())
                    .replace("ADDRESS", company.getAddress());
            cell2.setCellValue(result);

            String[] managerSplit = company.getManager().split(" ");
            int validW = managerSplit.length - 5 - 3;

            StringBuilder managerPostB = new StringBuilder();
            for (int i = 0; i < validW; i++) {
                managerPostB.append(managerSplit[i]).append(" ");
            }

            StringBuilder managerNameB = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                managerNameB.append(managerSplit[i + validW]).append(" ");
            }

            String name = managerNameB.toString();
            String post = managerPostB.toString();

            XSSFRow row3 = sheetUtil.getRow(sheet, 70);
            XSSFCell cell31 = sheetUtil.getCell(row3, 2);
            XSSFCell cell32 = sheetUtil.getCell(row3, 5);
            cell31.setCellValue(name);
            cell32.setCellValue(post + company.getTitle());

            XSSFRow row4 = sheetUtil.getRow(sheet, 70);
            XSSFCell cell41 = sheetUtil.getCell(row4, 2);
            XSSFCell cell42 = sheetUtil.getCell(row4, 5);
            cell41.setCellValue(name);
            cell42.setCellValue(post + company.getTitle());

            XSSFSheet sheet2 = sheets.get().getSheetAt(1);
            XSSFRow row5 = sheetUtil.getRow(sheet2, 5);
            sheetUtil.getCell(row5, 2).setCellValue(company.getTitle());
            sheetUtil.getCell(row5, 3).setCellValue(name + post + company.getTitle());
            sheetUtil.getCell(row5, 6).setCellValue(post + company.getTitle() + " " + name.trim());
            file.close();

            FileOutputStream outFile;
            outFile = new FileOutputStream("C:/Users/Nikita/OneDrive/Рабочий стол/files/example100.xlsx");
            sheets.get().write(outFile);

            outFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
