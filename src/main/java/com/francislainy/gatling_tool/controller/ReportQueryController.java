package com.francislainy.gatling_tool.controller;

import com.francislainy.gatling_tool.dto.ReportQueryDto;
import com.francislainy.gatling_tool.service.ReportQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RequestMapping("/api/gatling-tool/report")
@RestController
public class ReportQueryController {

    @Autowired
    private ReportQueryService reportQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<ReportQueryDto>> listAllReports() {

        Map result = new HashMap();
        result.put("reports", reportQueryService.listAllReports());
        return result;
        
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReportQueryDto> getReport(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(reportQueryService.getReport(id), HttpStatus.OK);
    }

}
