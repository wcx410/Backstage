package com;


public interface Sys_codesService {
    Sys_codes getByID(String str);
    void commitByID(String str, Integer num);
}
