package com;

import java.util.Set;

public class MyMenu extends Menu {
    private Set<MyMenu> children;
    private boolean checked = false;

    @Override
    public String toString() {
        return "MyMenu{" +
                "children=" + children +
                ", checked=" + checked +
                '}';
    }

    public MyMenu() {
    }

    public MyMenu(Set<MyMenu> children, boolean checked) {
        this.children = children;
        this.checked = checked;
    }

    public Set<MyMenu> getChildren() {
        return children;
    }

    public void setChildren(Set<MyMenu> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
