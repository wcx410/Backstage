package com;

public class Message {
    /**
     * 该操作是执行否成功
     */
    public Boolean flag;

    /**
     * 操作返回的消息, 该消息可以是字符串, 对象等
     */
    public Object msg;


    public Message(Boolean flag, Object msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Message() {

    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }
}
