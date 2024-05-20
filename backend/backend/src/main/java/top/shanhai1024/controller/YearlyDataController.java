package top.shanhai1024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shanhai1024.entity.PO.YearlyData;
import top.shanhai1024.service.impl.YearlyDataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class YearlyDataController {

    @Autowired
    private YearlyDataService yearlyDataService;

    @GetMapping("/echartsData")
    public List<List<Object>> getEchartsData() {
        List<YearlyData> yearlyDataList = yearlyDataService.getAllYearlyData();
        return transformData(yearlyDataList);
    }

    private List<List<Object>> transformData(List<YearlyData> yearlyDataList) {
        Map<String, Map<Integer, Double>> dataMap = new HashMap<>();
        List<Integer> years = new ArrayList<>();

        for (YearlyData data : yearlyDataList) {
            String category = data.getCategory().getName();
            int year = data.getYear();
            double value = data.getValue();

            dataMap.computeIfAbsent(category, k -> new HashMap<>()).put(year, value);
            if (!years.contains(year)) {
                years.add(year);
            }
        }

        List<List<Object>> result = new ArrayList<>();
        List<Object> header = new ArrayList<>();
        header.add("年份");
        header.addAll(years);
        result.add(header);

        dataMap.forEach((category, yearData) -> {
            List<Object> row = new ArrayList<>();
            row.add(category);
            years.forEach(year -> row.add(yearData.getOrDefault(year, null)));
            result.add(row);
        });

        return result;
    }
}
