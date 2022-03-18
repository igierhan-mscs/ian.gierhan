package ui;

import business.Ex2fSample;

public class Main {
    public static void main(String[] args) {
        Ex2fSample obj1;

//        obj1 = new Ex2fSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
//        System.out.println(obj1.test1());
//
//        obj1.setI1(1);
//        System.out.println(obj1.test1());
//
//        obj1.setI1(10);
//        System.out.println(obj1.test1());
//
//        obj1.setI1(11);
//        System.out.println(obj1.test1());
//
//        obj1 = new Ex2fSample(1, 1, 3.0, 4.0, "Aaaa", "Bbbb");
//        System.out.println(obj1.test2());
//
//        obj1.setI1(2);
//        System.out.println(obj1.test2());
//
//        obj1.setI1(3);
//        System.out.println(obj1.test2());
//
//        obj1 = new Ex2fSample(1, 2, 3.0, 4.0, "Aaaa", "Bbbb");
//        System.out.println(obj1.test3());
//
//        obj1.setS1("Bbbb");
//        System.out.println(obj1.test3());
//
//        obj1.setS1("Bbb");
//        System.out.println(obj1.test3());
//
//        obj1.setS1("C");
//        System.out.println(obj1.test3());
//
//        obj1.setS1("Bbbb ");
//        System.out.println(obj1.test3());
//
//        obj1.setS1("99");
//        obj1.setS2("100");
//        System.out.println(obj1.test3());
//
//        obj1 = new Ex2fSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
//        System.out.println(obj1.test4());
//
//        obj1.setD1(168.1);
//        System.out.println(obj1.test4());
//
//        obj1.setD1(40.0);
//        System.out.println(obj1.test4());
//
//        obj1.setD2(100.0);
//        System.out.println(obj1.test4());
//
//        obj1.setD2(10);
//        System.out.println(obj1.test4());
//
//        obj1.setD1(50);
//        System.out.println(obj1.test4());
//
//        obj1 = new Ex2fSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
//        System.out.println(obj1.test5());
//
//        obj1.setD1(168.1);
//        System.out.println(obj1.test5());
//
//        obj1.setD1(40.0);
//        System.out.println(obj1.test5());
//
//        obj1.setD2(100.0);
//        System.out.println(obj1.test5());
//
//        obj1.setD2(10);
//        System.out.println(obj1.test5());
//
//        obj1.setD1(50);
//        System.out.println(obj1.test5());
//
//        obj1 = new Ex2fSample();
//        System.out.println(obj1.test6());
//
//        obj1.setS1("");
//        System.out.println(obj1.test6());
//
//        obj1.setS1("aaaa ");
//        System.out.println(obj1.test6());
//
//        obj1.setS1("dddd");
//        System.out.println(obj1.test6());
//
//        obj1.setS1("aaaa");
//        System.out.println(obj1.test6());
//
//        obj1.setS1("cccc");
//        System.out.println(obj1.test6());

//      --------------------------------- Test code v2: if-else ---------------------------------
//        Ex2fSample obj1;
//
        obj1 = new Ex2fSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        if (obj1.test1() == false)
            System.out.println("test1(), correct result: " + obj1.test1());
        else
            System.err.println("*** test1(), incorrect result: " + obj1.test1());

        obj1.setI1(1);
        if (obj1.test1() == true)
            System.out.println("test1(), correct result: " + obj1.test1());
        else
            System.err.println("*** test1(), incorrect result: " + obj1.test1());

        obj1.setI1(10);
        if (obj1.test1() == true)
            System.out.println("test1(), correct result: " + obj1.test1());
        else
            System.err.println("*** test1(), incorrect result: " + obj1.test1());

        obj1.setI1(11);
        if (obj1.test1() == false)
            System.out.println("test1(), correct result: " + obj1.test1());
        else
            System.err.println("*** test1(), incorrect result: " + obj1.test1());

        obj1 = new Ex2fSample(1, 1, 3.0, 4.0, "Aaaa", "Bbbb");
        if (obj1.test2() == false)
            System.out.println("test2(), correct result: " + obj1.test2());
        else
            System.err.println("*** test2(), incorrect result: " + obj1.test2());

        obj1.setI1(2);
        if (obj1.test2() == true)
            System.out.println("test2(), correct result: " + obj1.test2());
        else
            System.err.println("*** test2(), incorrect result: " + obj1.test2());

        obj1.setI1(3);
        if (obj1.test2() == false)
            System.out.println("test2(), correct result: " + obj1.test2());
        else
            System.err.println("*** test2(), incorrect result: " + obj1.test2());

        obj1 = new Ex2fSample(1, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        if (obj1.test3().equals("Aaaa"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1.setS1("Bbbb");
        if (obj1.test3().equals("Bbbb"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1.setS1("Bbb");
        if (obj1.test3().equals("Bbb"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1.setS1("C");
        if (obj1.test3().equals("Bbbb"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1.setS1("Bbbb ");
        if (obj1.test3().equals("Bbbb"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1.setS1("99");
        obj1.setS2("100");
        if (obj1.test3().equals("100"))
            System.out.println("test3(), correct result: " + obj1.test3());
        else
            System.err.println("*** test3(), incorrect result: " + obj1.test3());

        obj1 = new Ex2fSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
        if (obj1.test4() == -1)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1.setD1(168.1);
        if (obj1.test4() == -1)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1.setD1(40.0);
        if (obj1.test4() == -1)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1.setD2(100.0);
        if (obj1.test4() == -1)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1.setD2(10);
        if (obj1.test4() == 400)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1.setD1(50);
        if (obj1.test4() == 550)
            System.out.println("test4(), correct result: " + obj1.test4());
        else
            System.err.println("*** test4(), incorrect result: " + obj1.test4());

        obj1 = new Ex2fSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
        if (obj1.test5() == -1)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1.setD1(168.1);
        if (obj1.test5() == -1)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1.setD1(40.0);
        if (obj1.test5() == -1)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1.setD2(100.0);
        if (obj1.test5() == -1)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1.setD2(10);
        if (obj1.test5() == 400)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1.setD1(50);
        if (obj1.test5() == 550)
            System.out.println("test5(), correct result: " + obj1.test5());
        else
            System.err.println("*** test5(), incorrect result: " + obj1.test5());

        obj1 = new Ex2fSample();
        if (obj1.test6() == false)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());

        obj1.setS1("");
        if (obj1.test6() == false)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());

        obj1.setS1("aaaa ");
        if (obj1.test6() == false)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());

        obj1.setS1("dddd");
        if (obj1.test6() == false)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());

        obj1.setS1("aaaa");
        if (obj1.test6() == true)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());

        obj1.setS1("cccc");
        if (obj1.test6() == true)
            System.out.println("test6(), correct result: " + obj1.test6());
        else
            System.err.println("*** test6(), incorrect result: " + obj1.test6());
    }
}
