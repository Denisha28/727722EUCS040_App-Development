package com.example.demo.service;

import com.example.demo.model.Receipt;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Optional<Receipt> getReceiptByDate(String date) {
        return receiptRepository.findById(date);
    }

    public Receipt createOrUpdateReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public void deleteReceipt(String date) {
        receiptRepository.deleteById(date);
    }
}
