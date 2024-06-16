package com.alura.literalura.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Operation {

    int operation;
    String bookName;

    public Operation(int operation) {
        this.operation = operation;
    }
}
