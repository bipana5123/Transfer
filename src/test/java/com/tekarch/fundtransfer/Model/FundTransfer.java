package com.tekarch.fundtransfer.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table("fund_transfers")  // Name of the table in the database

public class FundTransfer {




    @Table("fund_transfers")  // Name of the table in the database


        @Id
        private Long id;

        private Long senderAccountId;
        private Long receiverAccountId;
        private Double amount;
        private String transferDate;
        private String status;

        // Default constructor
        public FundTransfer() {}

        // Parameterized constructor
        public FundTransfer(Long senderAccountId, Long receiverAccountId, Double amount, String transferDate, String status) {
            this.senderAccountId = senderAccountId;
            this.receiverAccountId = receiverAccountId;
            this.amount = amount;
            this.transferDate = transferDate;
            this.status = status;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getSenderAccountId() {
            return senderAccountId;
        }

        public void setSenderAccountId(Long senderAccountId) {
            this.senderAccountId = senderAccountId;
        }

        public Long getReceiverAccountId() {
            return receiverAccountId;
        }

        public void setReceiverAccountId(Long receiverAccountId) {
            this.receiverAccountId = receiverAccountId;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getTransferDate() {
            return transferDate;
        }

        public void setTransferDate(String transferDate) {
            this.transferDate = transferDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
