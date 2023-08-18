package dev.thoourh.jpa.exception;



public class PostNotInBoardException extends BaseException {
    public PostNotInBoardException(String message) {
        super("Post not in board");
    }

    public PostNotInBoardException() {
        super();
    }
}
