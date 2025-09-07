package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter{
    NaiveCsvReader reader;
    ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service){
        this.reader = reader;
        this.service = service;
    }

    @Override
    public int importFrom(Path csvFile){
        List<String[]> rows = reader.read(csvFile);
        int successCount = 0;

        for (String[] row : rows) {
            if (row.length < 3) {
                System.out.println("Skipping invalid row (not enough columns)");
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            if (id.isEmpty() || email.isEmpty() || !email.contains("@")) {
                System.out.println("Skipping invalid row: " + String.join(",", row));
                continue;
            }

            service.createProfile(id, email, displayName);
            successCount++;
        }

        return successCount;
    }
}
