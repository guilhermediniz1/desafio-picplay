package com.guilherme.desafiopicplay.dto;

import lombok.Data;

@Data
public class RequestPostTransactionDto {
   private Integer amount;
   private Long payerId;
   private Long receiverId;
}
