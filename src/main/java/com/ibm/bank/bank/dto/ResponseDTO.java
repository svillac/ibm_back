package com.ibm.bank.bank.dto;

import java.util.Arrays;

public class ResponseDTO {
    private byte[] file;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "file=" + Arrays.toString(file) +
                '}';
    }
}
