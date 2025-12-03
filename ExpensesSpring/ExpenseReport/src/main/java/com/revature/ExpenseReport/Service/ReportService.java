package com.revature.ExpenseReport.Service;

import com.revature.ExpenseReport.Controller.ReportDTO;
import com.revature.ExpenseReport.Controller.ReportWOIDDTO;
import com.revature.ExpenseReport.Model.Report;
import com.revature.ExpenseReport.Repository.ReportRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository repository;

    public ReportService(ReportRepository repository){
        this.repository = repository;
    }

    public List<ReportDTO> getAllReports() {
        return repository.findAll().stream().map(this::ReportToDto).toList();
    }

    public ReportDTO getById(String id){
        return ReportToDto(repository.findById(id).get());
    }

    public List<ReportDTO> searchByReportTitle(String title) {
        return repository.findByReportTitle(title).stream().map(this::ReportToDto).toList();
    }

    public ReportDTO create(ReportWOIDDTO dto){
        Report entity = new Report(dto.reportTitle(), dto.reportStatus());
        return ReportToDto(repository.save(entity));
    }

    public ReportDTO update(String id, ReportDTO dto){
        Report report = repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        report.setReportTitle(dto.reportTitle());
        report.setReportStatus(dto.reportStatus());
        
        return ReportToDto(repository.save(report));
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    private ReportDTO ReportToDto(Report report){
        return new ReportDTO(report.getReportId(), report.getReportTitle(), report.getReportStatus());
    }
}
