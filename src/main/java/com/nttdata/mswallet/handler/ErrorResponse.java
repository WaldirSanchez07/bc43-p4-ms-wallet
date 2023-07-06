package com.nttdata.mswallet.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {

  private String message;
  private Integer status;
  private Map<String, String> errors;

}
