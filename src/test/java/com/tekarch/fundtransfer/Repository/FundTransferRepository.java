package com.tekarch.fundtransfer.Repository;

import com.tekarch.fundtransfer.Model.FundTransfer;
import com.tekarch.fundtransfer.Repository.FundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundTransferService {

    @Autowired
    private FundTransferRepository fundTransferRepository;

    // Method to initiate a fund transfer
    public FundTransfer initiateTransfer(FundTransfer fundTransfer) {
        // Here, you'd typically validate accounts, check for sufficient funds, etc.
        return fundTransferRepository.save(fundTransfer);
    }

    // Method to get transfer details by ID
    public FundTransfer getTransferById(Long id) {
        return fundTransferRepository.findTransferById(id);
    }

    // Method to update the transfer status (e.g., after processing)
    public FundTransfer updateTransferStatus(Long id, String status) {
        FundTransfer transfer = fundTransferRepository.findTransferById(id);
        if (transfer != null) {
            transfer.setStatus(status);
            return fundTransferRepository.save(transfer);
        }
        return null;  // Return null if transfer not found
    }
}
