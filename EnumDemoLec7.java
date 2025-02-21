

enum Prac{
    A,B,C,D,E,F,G;
    Prac(){
        System.out.println("Constructor Executed...");
    }
}

enum ConstDemo{
    A,B(),C(895),E(9024);//->No-arg,No-arg,int-arg,int-arg
    int price;
    ConstDemo(){
        this.price=60;
    }
    ConstDemo(int price){
        this.price=price;
    }
    public int getPrice() {
        return price;
    }
    
}

public class EnumDemoLec7 {
    public static void main(String[] args) {
        Prac p=Prac.A;//if we comment this line then Prac will not be loaded and hence constructor will not be executed
        // Prac p1=new Prac();->Invalid
        System.out.println("Hello Aj...");
        ConstDemo [] cd=ConstDemo.values();
        for(var a:cd){
            System.out.println(a+" "+a.getPrice());
        }
    }
}
// package com.proc.exam.util;

// import java.util.ArrayList;
// import java.util.List;

// import com.fasterxml.jackson.databind.PropertyNamingStrategies;
// import com.fasterxml.jackson.databind.annotation.JsonNaming;
// import com.proc.exam.exception.ErrorResponse;

// import lombok.Data;

// @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
// @Data
// public class ResponseEntity<T> {

//     private String             statusCode;
//     private String             message;
//     T                          response;
//     private String             stackTrace;
//     List<ErrorResponse>        errorResponse       = new ArrayList<>();
//     private String             requestId;
//     public static final String SUCCESS_STATUS_CODE = "200";
//     public static final String SUCCESS_STATUS_MSG  = "OK";
//     public static final String ERROR_STATUS_CODE   = "500";
//     public static final String ERROR_STATUS_MSG    = "Internal Server Error";

//     public ResponseEntity(T response) {
//         this(SUCCESS_STATUS_CODE, SUCCESS_STATUS_MSG, response);
//     }

//     public ResponseEntity(String statusCode, String message, T response) {
//         super();
//         this.statusCode = statusCode;
//         this.message = message;
//         this.response = response;
//     }

//     public ResponseEntity(String statusCode, String message, String requestId, T response) {
//         super();
//         this.statusCode = statusCode;
//         this.message = message;
//         this.response = response;
//         this.requestId = requestId;
//     }

//     public ResponseEntity(List<ErrorResponse> errorResponse, String stackTrace) {
//         this(errorResponse != null && !errorResponse.isEmpty() && errorResponse.get(0).getErrorCode() > 0 ? errorResponse.get(0).getErrorCode() + "" : ERROR_STATUS_CODE,
//                 errorResponse != null && !errorResponse.isEmpty() && Utilities.isNotBlank(errorResponse.get(0).getErrorMessage()) ? errorResponse.get(0).getErrorMessage() : ERROR_STATUS_MSG,
//                 null);

//         this.errorResponse = errorResponse;
//         this.stackTrace = stackTrace;
//     }

//     public ResponseEntity(String stackTrace, String requestId) {
//         this(ERROR_STATUS_CODE, ERROR_STATUS_MSG, null);
//         this.requestId = requestId;
//         this.stackTrace = stackTrace;
//     }

//     public ResponseEntity(List<ErrorResponse> errorResponse, String stackTrace, String requestId) {
//         this(ERROR_STATUS_CODE, ERROR_STATUS_MSG, null);
//         this.errorResponse = errorResponse;
//         this.stackTrace = stackTrace;
//         this.requestId = requestId;
//     }

// }

// --------------------------------------------------------------------------



/*
 package com.proc.exam.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExamException.class)
    public ResponseEntity<Object> handleCustomException(ExamException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getErrorResponses(), ex.getMessage(), null);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCustomException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), new ArrayList<>(), ex.getMessage(), null);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleCustomException(RuntimeException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), new ArrayList<>(), ex.getMessage(), null);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
*/
/*
 package com.proc.exam.exception;

import java.util.ArrayList;
import java.util.List;

public class ExamException extends RuntimeException {

    private static final long   serialVersionUID = 1L;

    private List<ErrorResponse> errorResponses   = new ArrayList<>();

    public ExamException() {
        super();
    }

    public ExamException(String message) {
        super(message);
    }

    public ExamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExamException(ErrorResponse errorResponse) {
        this();
        addErrorResponse(errorResponse);
    }

    public ExamException(String message, ErrorResponse errorResponse) {
        super(message);
        addErrorResponse(errorResponse);
    }

    public void addErrorResponse(ErrorResponse errorResponse) {
        errorResponses.add(errorResponse);
    }

    public List<ErrorResponse> getErrorResponses() {
        return errorResponses;
    }
}

*/