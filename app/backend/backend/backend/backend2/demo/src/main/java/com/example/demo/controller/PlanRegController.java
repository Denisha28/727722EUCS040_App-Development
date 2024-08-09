package com.example.demo.controller;

import com.example.demo.model.PlanReg;
import com.example.demo.service.PlanRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plans")
public class PlanRegController {

    @Autowired
    private PlanRegService planRegService;

    @GetMapping
    public List<PlanReg> getAllPlans() {
        return planRegService.getAllPlans();
    }

    @GetMapping("/{name}")
    public ResponseEntity<PlanReg> getPlanByName(@PathVariable String name) {
        Optional<PlanReg> plan = planRegService.getPlanByName(name);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlanReg createPlan(@RequestBody PlanReg planReg) {
        return planRegService.createOrUpdatePlan(planReg);
    }

    @PutMapping("/{name}")
    public ResponseEntity<PlanReg> updatePlan(@PathVariable String name, @RequestBody PlanReg planReg) {
        if (planRegService.getPlanByName(name).isPresent()) {
            planReg.setName(name);
            return ResponseEntity.ok(planRegService.createOrUpdatePlan(planReg));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlan(@PathVariable String name) {
        if (planRegService.getPlanByName(name).isPresent()) {
            planRegService.deletePlan(name);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
