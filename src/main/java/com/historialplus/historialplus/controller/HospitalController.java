package com.historialplus.historialplus.controller;

import com.historialplus.historialplus.dto.hospitalDTOs.response.HospitalResponseDto;
import com.historialplus.historialplus.service.hospitalservice.IHospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    private final IHospitalService service;

    public HospitalController(IHospitalService service) {
        this.service = service;
    }

    @GetMapping
    public Page<HospitalResponseDto> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ruc,
            @RequestParam(required = false) Integer id,
            Pageable pageable) {
        return service.findAll(name, ruc, id, pageable);
    }

}
