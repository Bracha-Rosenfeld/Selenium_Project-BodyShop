package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

//public class ExcelUtils {
//
//    public static void writeCartToExcel(
//            String filePath,
//            List<String> productNames,
//            List<Integer> quantities,
//            String total
//    ) {
//        try (Workbook wb = new XSSFWorkbook()) {
//            Sheet sheet = wb.createSheet("CartResults");
//            int rowNum = 0;
//
//            // header
//            Row header = sheet.createRow(rowNum++);
//            header.createCell(0).setCellValue("Product Name");
//            header.createCell(1).setCellValue("Quantity");
//
//            // items
//            for (int i = 0; i < productNames.size(); i++) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(productNames.get(i));
//                row.createCell(1).setCellValue(quantities.get(i));
//            }
//
//            // total line
//            Row totalRow = sheet.createRow(rowNum++);
//            totalRow.createCell(0).setCellValue("Total Amount");
//            totalRow.createCell(1).setCellValue(total);
//
//            // write file
//            FileOutputStream fos = new FileOutputStream(filePath);
//            wb.write(fos);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


public class ExcelUtils {

    public static void writeCartToExcel(
            String filePath,
            List<String> productNames,
            List<Integer> quantities,
            List<String> prices,
            List<String> subtotals,
            String total
    ) {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("CartResults");
            int rowNum = 0;

            // header
            Row header = sheet.createRow(rowNum++);
            header.createCell(0).setCellValue("Product Name");
            header.createCell(1).setCellValue("Quantity");
            header.createCell(2).setCellValue("Price");
            header.createCell(3).setCellValue("Subtotal");

            // items
            for (int i = 0; i < productNames.size(); i++) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(productNames.get(i));
                row.createCell(1).setCellValue(quantities.get(i));
                row.createCell(2).setCellValue(prices.get(i));
                row.createCell(3).setCellValue(subtotals.get(i));
            }

            // total line
            Row totalRow = sheet.createRow(rowNum++);
            totalRow.createCell(0).setCellValue("Total Amount");
            totalRow.createCell(3).setCellValue(total);

            // write file
            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);
            fos.close();

            System.out.println("Cart Excel created at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

