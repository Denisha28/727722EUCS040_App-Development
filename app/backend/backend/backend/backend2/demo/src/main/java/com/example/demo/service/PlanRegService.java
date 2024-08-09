package com.example.demo.service;

import com.example.demo.model.PlanReg;
import com.example.demo.repository.PlanRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanRegService {

    @Autowired
    private PlanRegRepository planRegRepository;

    public List<PlanReg> getAllPlans() {
        return planRegRepository.findAll();
    }

    public Optional<PlanReg> getPlanByName(String name) {
        return planRegRepository.findById(name);
    }

    public PlanReg createOrUpdatePlan(PlanReg planReg) {
        return planRegRepository.save(planReg);
    }

    public void deletePlan(String name) {
        planRegRepository.deleteById(name);
    }
}
