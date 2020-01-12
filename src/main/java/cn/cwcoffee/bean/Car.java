package cn.cwcoffee.bean;

/**
 * @Author cw
 * @Date 2020/1/12 11:48
 */
public class Car {

    public Car(){
        System.out.println("car...constructor...");
    }

    public void init(){
        System.out.println("car...init...");
    }

    public void destroy(){
        System.out.println("car...destroy...");
    }
}
