package com.jaaaelu.gzw.clean_code.fun;

public class F3_4 {
    //  3.4 switch 语句

    //  示例代码：

    private static final String COMMISSIONED = "COMMISSIONED";
    private static final String HOURLY = "HOURLY";
    private static final String SALARIED = "SALARIED";

    private class Money {
    }

    class Employee {
        String type;
    }

    private Money calculateCommissionedPay(Employee e) {
        return null;
    }

    private Money calculateHourlyPay(Employee e) {
        return null;
    }

    private Money calculateSalariedPay(Employee e) {
        return null;
    }

    //  作者认为这个函数有如下问题：
    //  1.太长，当有新的雇员类型出现时，还会变的更长
    //  2.它明显做了不止一件事
    //  3.为了单一权责原则
    //  4.每添加新类型时必须修改
    //  5.最麻烦的可能还是到处有类似解构的函数
    //      如：isPayday(Employee e, Date date)
    //          deliverPay(Employee e, Date date)

    public Money calculatePay(Employee e) throws Exception {
        switch (e.type) {
            case COMMISSIONED:
                return calculateCommissionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default:
                //  书中抛出了自定义异常
                throw new Exception(e.type);
        }
    }

    //  作者给出的解决方案：将 switch 语句埋到抽象工厂下面，不然任何人看到
    //  对于作者来说，switch 如果只出现一次，那么会用于创建多态对象，而且隐藏于某个集成关系中

    class EmployeeRecord {
        String type;
    }

    public abstract class BaseEmployee {

        public abstract boolean isPayday();

        public abstract Money calculatePay();

        public abstract void deliverPay(Money pay);
    }

    public interface EmployeeFactory {

        BaseEmployee makeEmployee(EmployeeRecord r) throws Exception;
    }

    class CommissionedEmployee extends BaseEmployee {

        @Override
        public boolean isPayday() {
            return false;
        }

        @Override
        public Money calculatePay() {
            return null;
        }

        @Override
        public void deliverPay(Money pay) {

        }
    }

    class HourlyEmployee extends BaseEmployee {

        @Override
        public boolean isPayday() {
            return false;
        }

        @Override
        public Money calculatePay() {
            return null;
        }

        @Override
        public void deliverPay(Money pay) {

        }
    }

    class SalariedEmployee extends BaseEmployee {

        @Override
        public boolean isPayday() {
            return false;
        }

        @Override
        public Money calculatePay() {
            return null;
        }

        @Override
        public void deliverPay(Money pay) {

        }
    }

    public class EmployeeFactoryImpl implements EmployeeFactory {

        @Override
        public BaseEmployee makeEmployee(EmployeeRecord r) throws Exception {
            switch (r.type) {
                case COMMISSIONED:
                    return new CommissionedEmployee();
                case HOURLY:
                    return new HourlyEmployee();
                case SALARIED:
                    return new SalariedEmployee();
                default:
                    //  书中抛出了自定义异常
                    throw new Exception(r.type);
            }
        }
    }
}
