package com.revature.ExpenseReport.Controller;

import com.revature.ExpenseReport.Service.ReportService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReportDTO> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/search")
    public List<ReportDTO> search(@RequestParam String title) {
        return service.searchByReportTitle(title);
    }

    @PostMapping
    public ReportDTO create(@RequestBody ReportWOIDDTO reportdto){
        return service.create(reportdto);
    }

    @GetMapping("/{id}")
    public ReportDTO getById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ReportDTO update(@PathVariable String id, @RequestBody ReportDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
