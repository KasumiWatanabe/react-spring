package com.udemy.react-spring.exception;

public class ItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(Long itemId) {
        super("商品コード:" + itemId + "は見つかりません。");
    }
}
