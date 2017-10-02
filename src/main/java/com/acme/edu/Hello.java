package com.acme.edu;

public class Hello {
    public static void main(String[] args) {
        LoggerFacade.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        LoggerFacade.stopLogging();
    }
}
