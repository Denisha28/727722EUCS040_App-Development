package com.example.demo.controller;

import com.example.demo.model.Receipt;
import com.example.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{date}")
    public ResponseEntity<Receipt> getReceiptByDate(@PathVariable String date) {
        Optional<Receipt> receipt = receiptService.getReceiptByDate(date);
        return receipt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Receipt createReceipt(@RequestBody Receipt receipt) {
        return receiptService.createOrUpdateReceipt(receipt);
    }

    @PutMapping("/{date}")
    public ResponseEntity<Receipt> updateReceipt(@PathVariable String date, @RequestBody Receipt receipt) {
        if (receiptService.getReceiptByDate(date).isPresent()) {
            receipt.setDate(date);
            return ResponseEntity.ok(receiptService.createOrUpdateReceipt(receipt));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable String date) {
        if (receiptService.getReceiptByDate(date).isPresent()) {
            receiptService.deleteReceipt(date);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
