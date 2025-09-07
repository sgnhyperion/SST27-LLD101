package com.example.report;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        // TODO: Replace the above with a single call to ReportBundleFacade.export(...)

        ReportBundleFacade facade = new ReportBundleFacade();
        facade.export(data);
    }
}
