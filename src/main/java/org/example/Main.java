package org.example;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("D:\\excelTest/SNS 대화 데이터 제공(Template) Ver 1.3.xlsx"); ReadableWorkbook wb = new ReadableWorkbook(is)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    System.out.println(r.getCellCount() + r.getCellAsString(1).orElse(null));
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}