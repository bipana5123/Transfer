package com.tekarch.fundtransfer.Controller;





import com.tekarch.fundtransfer.Model.FundTransfer;
import com.tekarch.fundtransfer.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

    @RestController
    @RequestMapping("/api/fund-transfer")
    public class FundTransferController {

        @Autowired
        private FundTransferService fundTransferService;

        // Endpoint to initiate a fund transfer
        @PostMapping("/transfer")
        public ResponseEntity<FundTransfer> initiateTransfer(@Valid @RequestBody FundTransfer fundTransfer) {
            try {
                FundTransfer transfer = fundTransferService.initiateTransfer(fundTransfer);
                return new ResponseEntity<>(transfer, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // Endpoint to get transfer details by ID
        @GetMapping("/transfer/{id}")
        public ResponseEntity<FundTransfer> getTransferById(@PathVariable("id") Long id) {
            FundTransfer transfer = fundTransferService.getTransferById(id);
            return transfer != null ? ResponseEntity.ok(transfer) : ResponseEntity.notFound().build();
        }

        // Endpoint to update the status of a fund transfer
        @PatchMapping("/transfer/{id}/status")
        public ResponseEntity<FundTransfer> updateTransferStatus(@PathVariable("id") Long id, @RequestParam String status) {
            FundTransfer updatedTransfer = fundTransferService.updateTransferStatus(id, status);
            return updatedTransfer != null ? ResponseEntity.ok(updatedTransfer) : ResponseEntity.notFound().build();
        }
    }
