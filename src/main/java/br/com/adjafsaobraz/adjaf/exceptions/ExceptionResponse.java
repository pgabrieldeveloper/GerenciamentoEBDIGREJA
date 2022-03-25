package br.com.adjafsaobraz.adjaf.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date data;
    private String message;
    private String details;

    public ExceptionResponse(Date data, String message, String details) {
        this.data = data;
        this.message = message;
        this.details = details;
    }

    public Date getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
