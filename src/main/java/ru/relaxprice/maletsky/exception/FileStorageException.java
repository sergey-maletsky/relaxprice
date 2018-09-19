package ru.relaxprice.maletsky.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException() {

    }

    public FileStorageException(String message) {

        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
