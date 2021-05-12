package com;

import lombok.Data;

import java.util.List;

@Data
public class Menus extends Menu {
    List<Menu> children;
}
