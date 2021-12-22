package test;

public class test01 {
    private String name;
    private int id;

    public test01()
    {

    }

    public test01(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        String str = "张三";
        return name;
    }

    public int getId() {
        return id;
    }
}
